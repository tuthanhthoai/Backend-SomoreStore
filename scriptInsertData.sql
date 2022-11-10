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
insert into customer(address,email,image,name,phone,sex,status) values("1 Vo Van Ngan","giangnam123@gmail.com","????","Vo Giang Nam","01234167812",1,1);
insert into customer(address,email,image,name,phone,sex,status) values("2 Vo Van Ngan","thanhthoai123@gmail.com","????","Tu Thanh Thoai","01234167813",1,1);
insert into customer(address,email,image,name,phone,sex,status) values("3 Vo Van Ngan","tiendi123@gmail.com","????","Huynh Tien Di","01234167814",1,1);
insert into customer(address,email,image,name,phone,sex,status) values("4 Vo Van Ngan","huudat123@gmail.com","????","Nguyen Huu Dat","01234167815",1,1);

/*Insert data login*/
insert into login(username,password,role,session,customer_id)
values("giangnam123","$2a$12$Yn2KMYCRbcVZZo.KE3xmzukPzZboQm8S3v.81ZRN5m2VI1cTsMLDO",0,NULL,1);
insert into login(username,password,role,session,customer_id)
values("thanhthoai123","$2a$12$Yn2KMYCRbcVZZo.KE3xmzukPzZboQm8S3v.81ZRN5m2VI1cTsMLDO",0,NULL,2);
insert into login(username,password,role,session,customer_id)
values("tiendi123","$2a$12$Yn2KMYCRbcVZZo.KE3xmzukPzZboQm8S3v.81ZRN5m2VI1cTsMLDO",1,NULL,3);
insert into login(username,password,role,session,customer_id)
values("huudat123","$2a$12$Yn2KMYCRbcVZZo.KE3xmzukPzZboQm8S3v.81ZRN5m2VI1cTsMLDO",0,NULL,4);

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

/*Insert data product*/
-- DROP PROCEDURE IF EXISTS insert_data_to_product;
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
fetch cur into color_test,image_test,money_test,name_test,brandId_test,categoryId_test;
	read_loop: LOOP
		start transaction;
			IF done THEN
			  LEAVE read_loop;
			END IF;
            set @product_name = name_test; -- Lấy name của product
			set @count_name = (select count(name) from test where name = @product_name); -- Lấy ra số lượng tên trùng
			insert ignore into product (description,discount,money,name,sold_quantity,stock,brand_id,category_id)
			values ("",0,money_test,name_test,0,12,brandId_test,categoryId_test);
			set @product_id=last_insert_id();
			set @count_quantity = 12 / @count_name;
			while @count_name >= 1 DO 
				set @color_id = (select color_id from color where color = color_test);
				insert ignore into image (image)
				values (image_test);
				set @image_id=last_insert_id();
				insert ignore into product_color (product_id,color_id,stock)
				values (@product_id,@color_id,@count_quantity);
				insert ignore into product_image (product_id,image_id)
				values (@product_id,@image_id);
				fetch cur into color_test,image_test,money_test,name_test,brandId_test,categoryId_test;
				set @count_name = @count_name - 1;
			end while;
			insert ignore into product_size (product_id,size_id,quantity)
			values (@product_id,1,6);
			insert ignore into product_size (product_id,size_id,quantity)
			values (@product_id,2,6);
		commit;
	END LOOP;
CLOSE cur;
end #
delimiter ;

call insert_data_to_product();

/*Insert Data order_shoes*/
insert into order_shoes(discount,order_date,payment_status,total_price,customer_id)
values(10,'2022-11-08',1,423,1);
set @order_id=last_insert_id();
insert into product_order(product_id,order_id,quantity)
values (1,@order_id,2);
set @product_id = 1;
set @quantity = 2;
set @temp_Sold = (select sold_quantity from product where product_id = @product_id );
set @temp_Stock = (select stock from product where product_id = @product_id );
update product
set sold_quantity = @temp_Sold + @quantity, stock = @temp_Stock - @quantity
where product_id = @product_id;
insert into product_order(product_id,order_id,quantity)
values (2,@order_id,2);
set @product_id = 2;
set @quantity = 2;
set @temp_Sold = (select sold_quantity from product where product_id = @product_id );
set @temp_Stock = (select stock from product where product_id = @product_id );
update product
set sold_quantity = @temp_Sold + @quantity, stock = @temp_Stock - @quantity
where product_id = @product_id;
insert into product_order(product_id,order_id,quantity)
values (5,@order_id,2);
set @product_id = 5;
set @quantity = 2;
set @temp_Sold = (select sold_quantity from product where product_id = @product_id );
set @temp_Stock = (select stock from product where product_id = @product_id );
update product
set sold_quantity = @temp_Sold + @quantity, stock = @temp_Stock - @quantity
where product_id = @product_id;

/*Insert Data order_shoes*/
insert into order_shoes(discount,order_date,payment_status,total_price,customer_id)
values(0,'2022-11-08',0,725,2);
set @order_id=last_insert_id();
insert into product_order(product_id,order_id,quantity)
values (10,@order_id,3);
set @product_id = 10;
set @quantity = 3;
set @temp_Sold = (select sold_quantity from product where product_id = @product_id );
set @temp_Stock = (select stock from product where product_id = @product_id );
update product
set sold_quantity = @temp_Sold + @quantity, stock = @temp_Stock - @quantity
where product_id = @product_id;
insert into product_order(product_id,order_id,quantity)
values (11,@order_id,2);
set @product_id = 11;
set @quantity = 2;
set @temp_Sold = (select sold_quantity from product where product_id = @product_id );
set @temp_Stock = (select stock from product where product_id = @product_id );
update product
set sold_quantity = @temp_Sold + @quantity, stock = @temp_Stock - @quantity
where product_id = @product_id;
insert into product_order(product_id,order_id,quantity)
values (12,@order_id,4);
set @product_id = 12;
set @quantity = 4;
set @temp_Sold = (select sold_quantity from product where product_id = @product_id );
set @temp_Stock = (select stock from product where product_id = @product_id );
update product
set sold_quantity = @temp_Sold + @quantity, stock = @temp_Stock - @quantity
where product_id = @product_id;

/*Insert Data order_shoes*/
insert into order_shoes(discount,order_date,payment_status,total_price,customer_id)
values(10,'2022-11-08',1,387,3);
set @order_id=last_insert_id();
insert into product_order(product_id,order_id,quantity)
values (24,@order_id,2);
set @product_id = 24;
set @quantity = 2;
set @temp_Sold = (select sold_quantity from product where product_id = @product_id );
set @temp_Stock = (select stock from product where product_id = @product_id );
update product
set sold_quantity = @temp_Sold + @quantity, stock = @temp_Stock - @quantity
where product_id = @product_id;
insert into product_order(product_id,order_id,quantity)
values (33,@order_id,2);
set @product_id = 33;
set @quantity = 2;
set @temp_Sold = (select sold_quantity from product where product_id = @product_id );
set @temp_Stock = (select stock from product where product_id = @product_id );
update product
set sold_quantity = @temp_Sold + @quantity, stock = @temp_Stock - @quantity
where product_id = @product_id;
insert into product_order(product_id,order_id,quantity)
values (49,@order_id,2);
set @product_id = 49;
set @quantity = 2;
set @temp_Sold = (select sold_quantity from product where product_id = @product_id );
set @temp_Stock = (select stock from product where product_id = @product_id );
update product
set sold_quantity = @temp_Sold + @quantity, stock = @temp_Stock - @quantity
where product_id = @product_id;