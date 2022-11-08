use somorestore;

/*Insert data brand*/
insert into brand values(1,"ADIDAS");
insert into brand values(2,"NIKE");
insert into brand values(3,"VANS");
insert into brand values(4,"SKECHERS");
insert into brand values(5,"PUMA");
insert into brand values(6,"CONVERSE");

/*Insert data category*/
insert into category values(1,"Men");
insert into category values(2,"Women");

/*Insert data customer*/
insert into customer values(1,"1 Vo Van Ngan","giangnam123@gmail.com","????","Vo Giang Nam","01234167812",1);
insert into customer values(2,"2 Vo Van Ngan","thanhthoai123@gmail.com","????","Tu Thanh Thoai","01234167813",1);
insert into customer values(3,"3 Vo Van Ngan","tiendi123@gmail.com","????","Huynh Tien Di","01234167814",1);
insert into customer values(4,"4 Vo Van Ngan","huudat123@gmail.com","????","Nguyen Huu Dat","01234167815",1);

/*Insert data login*/
insert into login values("giangnam123","12345678",0,NULL,1);
insert into login values("thanhthoai123","12345678",0,NULL,2);
insert into login values("tiendi123","12345678",1,NULL,3);
insert into login values("huudat123","12345678",0,NULL,4);

/*Insert data color*/
insert into color(color) values("white");
insert into color(color) values("black");
insert into color(color) values("grey");
insert into color(color) values("olive");
insert into color(color) values("silver");
insert into color(color) values("red");
insert into color(color) values("multicolor");
insert into color(color) values("gold");
insert into color(color) values("wheat");
insert into color(color) values("bone");
insert into color(color) values("pink");
insert into color(color) values("purple");
insert into color(color) values("green");
insert into color(color) values("blue");
insert into color(color) values("yellow");
insert into color(color) values("brown");
insert into color(color) values("beige");
insert into color(color) values("wine");
insert into color(color) values("orange");
insert into color(color) values("navy");

/*Insert data size*/
insert into size (size) values(4.5);
insert into size (size) values(5.0);
insert into size (size) values(5.5);
insert into size (size) values(6.0);
insert into size (size) values(6.5);
insert into size (size) values(7.0);
insert into size (size) values(7.5);
insert into size (size) values(8.0);
insert into size (size) values(8.5);
insert into size (size) values(9.0);
insert into size (size) values(9.5);
insert into size (size) values(10.0);
insert into size (size) values(10.5);
insert into size (size) values(11.0);
insert into size (size) values(11.5); 	 	
insert into size (size) values(12.0);
insert into size (size) values(13.0);

-- drop table test;
create table test(
	product_id bigint primary key auto_increment,
    color VARCHAR(255),
    image VARCHAR(255),
    money BIGINT,
    name VARCHAR(255),
    brand_id BIGINT,
    category_id BIGINT
);

-- /*Insert data product*/
-- /*1*/
-- insert into product (description,discount,money,name,sold_quantity,stock,brand_id,category_id)
-- values ("",0,74.99,"ADIDAS MENS RACER TR21 SNEAKER",0,10,1,1);
-- set @product_id=last_insert_id();
-- set @color_id = (select color_id from color where color ='white');
-- insert ignore into image (image)
-- values ("https://deichmann.scene7.com/asset/deichmann/US_01_600855_01?$rr_main$&defaultImage=default_obs");
-- set @image_id=last_insert_id();
-- insert ignore into product_color (product_id,color_id)
-- values (@product_id,@color_id);
-- insert ignore into product_image (product_id,image_id)
-- values (@product_id,@image_id);

-- /*2*/
-- insert into product (description,discount,money,name,sold_quantity,stock,brand_id,category_id)
-- values ("",0,74.99,"ADIDAS MENS RACER TR21 SNEAKER",0,10,1,1);
-- set @product_id=last_insert_id();
-- set @color_id = (select color_id from color where color ='black');
-- insert ignore into image (image)
-- values ("https://deichmann.scene7.com/asset/deichmann/US_01_600625_01?$rr_main$&defaultImage=default_obs");
-- set @image_id=last_insert_id();
-- insert ignore into product_color (product_id,color_id)
-- values (@product_id,@color_id);
-- insert ignore into product_image (product_id,image_id)
-- values (@product_id,@image_id);

/*Insert data product*/
delimiter #
create procedure insert_data_to_product()
begin
DECLARE done boolean DEFAULT FALSE;
declare color_test varchar(500);
declare image_test varchar(500);
declare money_test bigint;
declare name_test varchar(500);
declare brandId_test bigint;
declare categoryId_test bigint;
declare cur cursor for select color,image,money,name,brand_id,category_id from test;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
open cur;
  
  read_loop: LOOP
	fetch cur into color_test,image_test,money_test,name_test,brandId_test,categoryId_test;
	start transaction;
	IF done THEN
      LEAVE read_loop;
	END IF;
    insert into product (description,discount,money,name,sold_quantity,stock,brand_id,category_id)
	values ("",0,money_test,name_test,0,10,brandId_test,categoryId_test);
	set @product_id=last_insert_id();
	set @color_id = (select color_id from color where color = color_test);
	insert ignore into image (image)
	values (image_test);
	set @image_id=last_insert_id();
	insert ignore into product_color (product_id,color_id)
	values (@product_id,@color_id);
	insert ignore into product_image (product_id,image_id)
	values (@product_id,@image_id);
    commit;
  END LOOP;
  CLOSE cur;
end #
delimiter ;

call insert_data_to_product();

/*Insert Data order_shoes*/
insert into order_shoes(discount,order_date,payment_status,quantity,total_price,customer_id)
values(10,'2022-11-08',1,5,360,1);
set @order_id=last_insert_id();
insert into product_order(product_id,order_id)
values (1,@order_id);
insert into product_order(product_id,order_id)
values (2,@order_id);
insert into product_order(product_id,order_id)
values (3,@order_id);
insert into product_order(product_id,order_id)
values (4,@order_id);
insert into product_order(product_id,order_id)
values (5,@order_id);

/*Insert Data order_shoes*/
insert into order_shoes(discount,order_date,payment_status,quantity,total_price,customer_id)
values(0,'2022-11-08',0,4,330,2);
set @order_id=last_insert_id();
insert into product_order(product_id,order_id)
values (4,@order_id);
insert into product_order(product_id,order_id)
values (7,@order_id);
insert into product_order(product_id,order_id)
values (9,@order_id);
insert into product_order(product_id,order_id)
values (10,@order_id);

insert into order_shoes(discount,order_date,payment_status,quantity,total_price,customer_id)
values(10,'2022-11-08',1,6,405,3);
set @order_id=last_insert_id();
insert into product_order(product_id,order_id)
values (15,@order_id);
insert into product_order(product_id,order_id)
values (17,@order_id);
insert into product_order(product_id,order_id)
values (50,@order_id);
insert into product_order(product_id,order_id)
values (60,@order_id);
insert into product_order(product_id,order_id)
values (100,@order_id);
insert into product_order(product_id,order_id)
values (119,@order_id);
