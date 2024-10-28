-- Borrar datos existentes
DELETE FROM `productos_favoritos`;
DELETE FROM `producto`;
DELETE FROM `categoria`;
DELETE FROM `usuario`;

-- Reseteo de AUTO_INCREMENT
ALTER TABLE `categoria` AUTO_INCREMENT = 1;
ALTER TABLE `producto` AUTO_INCREMENT = 1;
ALTER TABLE `usuario` AUTO_INCREMENT = 1;

-- Inserts para la tabla `categoria`
INSERT INTO `categoria` (`id`, `nombre`) VALUES
(1, 'Electrónica'),
(2, 'Hogar y Cocina'),
(3, 'Ropa y Accesorios'),
(4, 'Juguetes y Juegos'),
(5, 'Deportes');

-- Inserts para la tabla `producto`
INSERT INTO `producto` (`id`, `referencia`, `nombre`, `precio`, `categoria`) VALUES
(1, 'E12345', 'Televisor 4K', '450.00', 1),
(2, 'E67890', 'Teléfono Inteligente', '299.99', 1),
(3, 'H12345', 'Licuadora', '39.99', 2),
(4, 'H67890', 'Aspiradora', '99.00', 2),
(5, 'R12345', 'Chaqueta de Invierno', '59.95', 3),
(6, 'R67890', 'Zapatos Deportivos', '79.50', 3),
(7, 'J12345', 'Lego Starship', '89.99', 4),
(8, 'J67890', 'Puzzle de 1000 piezas', '15.99', 4),
(9, 'D12345', 'Pelota de fútbol', '19.99', 5),
(10, 'D67890', 'Bicicleta de montaña', '120.00', 5);

-- Inserts para la tabla `usuario`
INSERT INTO `usuario` (`id`, `nombre`) VALUES
(1, 'Juan Pérez'),
(2, 'María López'),
(3, 'Carlos Gómez'),
(4, 'Laura Martínez'),
(5, 'Ana Torres'),
(6, 'Luis Morales');

-- Inserts para la tabla `productos_favoritos`
INSERT INTO `productos_favoritos` (`idUsuario`, `idProducto`) VALUES
(1, 1),
(1, 3),
(2, 5),
(2, 7),
(3, 2),
(3, 8),
(4, 4),
(5, 9),
(5, 10),
(6, 6);
