use projekt2_gruppe_2;

insert into wishcategories (title, image) values
('Electronic','categories.electronic.jpg'),
('Makeup','categories.makeup.jpg'),
('Phone','categories.phone.jpg'),
('Computer','categories.computer.jpg'),
('Book','categories.book.jpg'),
('Clothing','categories.clothing.jpg'),
('Video Game','categories.video_game.jpg'),
('Plates','categories.plates.jpg'),
('Cups','categories.cups.jpg'),
('Candy','categories.candy.jpg');


insert into user (name, email, password) VALUES
('Nicklas','nicklas@lyager.me','123'),
('Jesper','Jesper@ymail.com','321'),
('William','william@gmail.com','123'),
('Mikkel','mikkel@hotmail.com','321');


insert into wishlist (title, description, image, userID) VALUES
('Christmas List','What i wish for christmas',null ,1),
('My Christmas List','My christmas list for christmas eve',null,2),
('Christmas List','',null,3),
('Birthday Wishlist','For my birthday',null,1),
('My Birthday List','But what i want',null,3),
('Birthday','',null,4),
('List for my Confirmation','Thanks for coming to my confirmation, here is what im wishing',null,1),
('Confirmation wishlist', '',null,2),
('My confirmation','may 21, will be my confirmation, here is my list',null,4);


insert into wish (title, description, price, link, reserveID, listID, categoryID) values

-- Wishlist 1: Nicklas' Christmas List
('Wireless Headphones', 'Noise cancelling headphones', 899, 'https://www.sony.com', NULL, 1, 1),
('Mechanical Keyboard', 'Mechanical keyboard for programming', 699, 'https://www.logitech.com', NULL, 1, 4),
('Fallout Merchandise', 'Something related to Fallout', 250, NULL, NULL, 1, 7),
('Programming Book', 'A book about Java programming', 299, 'https://www.amazon.com', 2, 1, 5),
('Coffee Mug', 'A nice mug for my desk', 89, NULL, NULL, 1, 9),
('Gaming Mouse', 'A precise gaming mouse', 399, 'https://www.logitech.com', NULL, 1, 4),

-- Wishlist 2: Jesper's Christmas List
('Gaming Headset', 'A headset with a good microphone', 599, NULL, NULL, 2, 1),
('New Phone Case', 'A protective phone case', 199, NULL, NULL, 2, 3),
('Hoodie', 'A comfortable black hoodie', 349, NULL, NULL, 2, 6),
('Chocolate Box', 'A box of assorted chocolates', 79, NULL, 3, 2, 10),
('Computer Mouse', 'Wireless computer mouse', 249, NULL, NULL, 2, 4),

-- Wishlist 3: William's Christmas List
('Steam Gift Card', 'Money for games on Steam', 200, 'https://store.steampowered.com', NULL, 3, 7),
('Fantasy Novel', 'A fantasy book for the holidays', 199, NULL, NULL, 3, 5),
('Bluetooth Speaker', 'Portable speaker for music', 499, NULL, NULL, 3, 1),
('New T-Shirt', 'A shirt in my favourite colour', 149, NULL, NULL, 3, 6),
('Phone Charger', 'A fast USB-C charger', 179, NULL, NULL, 3, 3),

-- Wishlist 4: Nicklas' Birthday Wishlist
('Gaming Monitor', 'A monitor with a high refresh rate', 1999, NULL, NULL, 4, 4),
('Java Reference Book', 'A reference book for Java developers', 349, NULL, NULL, 4, 5),
('Wireless Earbuds', 'Small wireless earbuds', 599, NULL, NULL, 4, 1),
('Retro Game', 'A classic video game', 299, NULL, NULL, 4, 7),

-- Wishlist 5: William's Birthday List
('Smartphone Stand', 'A stand for my phone', 129, NULL, NULL, 5, 3),
('Gaming Controller', 'A wireless controller', 499, NULL, NULL, 5, 7),
('Desk Lamp', 'A lamp for my computer desk', 249, NULL, NULL, 5, 1),
('Novel Collection', 'A collection of fantasy novels', 399, NULL, NULL, 5, 5),

-- Wishlist 6: Mikkel's Birthday List
('Wireless Keyboard', 'A compact keyboard', 399, NULL, NULL, 6, 4),
('Sneakers', 'Everyday casual sneakers', 699, NULL, NULL, 6, 6),
('Coffee Cups', 'A set of four coffee cups', 159, NULL, NULL, 6, 9),
('Candy Selection', 'A large selection of sweets', 99, NULL, NULL, 6, 10),

-- Wishlist 7: Nicklas' Confirmation List
('Laptop Backpack', 'A backpack for my laptop', 499, NULL, NULL, 7, 4),
('Java Programming Course', 'A course for learning Java', 499, NULL, NULL, 7, 5),
('Smartphone', 'A new smartphone', 4999, NULL, NULL, 7, 3),
('Gaming Headphones', 'Comfortable headphones for gaming', 799, NULL, NULL, 7, 1),

-- Wishlist 8: Jesper's Confirmation List
('Wireless Earphones', 'Earphones for listening to music', 399, NULL, NULL, 8, 1),
('Dress Shirt', 'A shirt for special occasions', 299, NULL, NULL, 8, 6),
('Computer Game', 'A new game for my collection', 249, NULL, NULL, 8, 7),
('Dessert Plates', 'A set of small dessert plates', 179, NULL, NULL, 8, 8),

-- Wishlist 9: Mikkel's Confirmation List
('Gaming Laptop', 'A laptop for gaming and school', 7999, NULL, NULL, 9, 4),
('Watch', 'A simple everyday watch', 499, NULL, NULL, 9, 6),
('Book Collection', 'Several books from my favourite series', 599, NULL, NULL, 9, 5),
('Candy Gift Box', 'A box filled with assorted candy', 149, NULL, NULL, 9, 10);

INSERT INTO wishListSharedWith (userID, listID) VALUES
(2, 1),
(3, 1),
(1, 2),
(4, 2),
(2, 3),
(4, 4),
(1, 5),
(3, 6),
(2, 7),
(4, 8),
(1, 9);