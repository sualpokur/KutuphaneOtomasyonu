-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 19 Oca 2021, 18:06:26
-- Sunucu sürümü: 8.0.17
-- PHP Sürümü: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `kutuphaneotomasyonu`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `dönenkitap`
--

CREATE TABLE `dönenkitap` (
  `id` int(11) NOT NULL,
  `mid` int(11) NOT NULL,
  `misim` varchar(255) NOT NULL,
  `kitapismi` varchar(255) NOT NULL,
  `dönüştarihi` varchar(255) NOT NULL,
  `gecen` int(11) NOT NULL,
  `ceza` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `dönenkitap`
--

INSERT INTO `dönenkitap` (`id`, `mid`, `misim`, `kitapismi`, `dönüştarihi`, `gecen`, `ceza`) VALUES
(8, 5, 'Hasan', 'Koca Dünya', '2021-01-12', 0, 0),
(19, 9, 'Aras', 'Koca Dünya', '2021-01-03', 16, 1600),
(20, 12, 'Veli', 'Koca Dünya', '2021-01-09', 10, 1000);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kategori`
--

CREATE TABLE `kategori` (
  `id` int(11) NOT NULL,
  `kategoriismi` varchar(255) NOT NULL,
  `durum` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `kategori`
--

INSERT INTO `kategori` (`id`, `kategoriismi`, `durum`) VALUES
(18, 'Komedi', 'Aktif'),
(19, 'Roman', 'Aktif'),
(20, 'Hikaye', 'Aktif Değil');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitap`
--

CREATE TABLE `kitap` (
  `id` int(11) NOT NULL,
  `kitapismi` varchar(255) NOT NULL,
  `kategori` int(11) NOT NULL,
  `yazar` int(11) NOT NULL,
  `yayımcı` int(11) NOT NULL,
  `içerik` varchar(255) NOT NULL,
  `sayfalar` int(11) NOT NULL,
  `baskı` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `kitap`
--

INSERT INTO `kitap` (`id`, `kitapismi`, `kategori`, `yazar`, `yayımcı`, `içerik`, `sayfalar`, `baskı`) VALUES
(1, 'Koca Dünya', 17, 5, 8, 'Bilim Kurgu', 239, 1),
(2, 'Momo', 19, 5, 8, 'Çocuk Hikayesi', 124, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `verilenkitap`
--

CREATE TABLE `verilenkitap` (
  `id` int(11) NOT NULL,
  `üyeid` int(11) NOT NULL,
  `kitapid` int(11) NOT NULL,
  `verilentarih` date NOT NULL,
  `dönüştarihi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `verilenkitap`
--

INSERT INTO `verilenkitap` (`id`, `üyeid`, `kitapid`, `verilentarih`, `dönüştarihi`) VALUES
(10, 1, 2, '2021-01-03', '2021-01-08'),
(16, 10, 1, '2021-01-17', '2021-01-23');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `yayımcı`
--

CREATE TABLE `yayımcı` (
  `id` int(11) NOT NULL,
  `isim` varchar(255) NOT NULL,
  `adres` text NOT NULL,
  `telefon` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `yayımcı`
--

INSERT INTO `yayımcı` (`id`, `isim`, `adres`, `telefon`) VALUES
(8, 'Palme', 'Beypazari', '516594'),
(9, 'İşler', 'Sincan', '4324123');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `yazar`
--

CREATE TABLE `yazar` (
  `id` int(11) NOT NULL,
  `isim` varchar(255) NOT NULL,
  `adres` text NOT NULL,
  `telefon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `yazar`
--

INSERT INTO `yazar` (`id`, `isim`, `adres`, `telefon`) VALUES
(5, 'Adnan K', 'Ankara', 5426);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `üye`
--

CREATE TABLE `üye` (
  `id` int(11) NOT NULL,
  `isim` varchar(255) NOT NULL,
  `adres` varchar(255) NOT NULL,
  `telefon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Tablo döküm verisi `üye`
--

INSERT INTO `üye` (`id`, `isim`, `adres`, `telefon`) VALUES
(5, 'Hasan', 'Ankara', 124124),
(6, 'Hakan', 'Polatlı	', 124124),
(7, 'Ali', 'fasf', 1),
(8, 'Uygar', 'Polatlı', 741),
(9, 'Aras', 'Etimesgut	', 123),
(10, 'Harun', 'Ulus	', 14),
(11, 'Mustafa', 'Ücret', 124124),
(12, 'Veli', 'Ortaçekmece', 124124),
(13, 'OKSFOSF', 'fsafsa', 1);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `dönenkitap`
--
ALTER TABLE `dönenkitap`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `kitap`
--
ALTER TABLE `kitap`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `verilenkitap`
--
ALTER TABLE `verilenkitap`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `yayımcı`
--
ALTER TABLE `yayımcı`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `yazar`
--
ALTER TABLE `yazar`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `üye`
--
ALTER TABLE `üye`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `dönenkitap`
--
ALTER TABLE `dönenkitap`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Tablo için AUTO_INCREMENT değeri `kategori`
--
ALTER TABLE `kategori`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Tablo için AUTO_INCREMENT değeri `kitap`
--
ALTER TABLE `kitap`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `verilenkitap`
--
ALTER TABLE `verilenkitap`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Tablo için AUTO_INCREMENT değeri `yayımcı`
--
ALTER TABLE `yayımcı`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Tablo için AUTO_INCREMENT değeri `yazar`
--
ALTER TABLE `yazar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `üye`
--
ALTER TABLE `üye`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
