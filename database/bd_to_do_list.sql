-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 07-Fev-2017 às 02:03
-- Versão do servidor: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bd_to_do_list`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `sub_task`
--

CREATE TABLE `sub_task` (
  `sub_task_id` bigint(20) NOT NULL,
  `sub_task_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `sub_task`
--

INSERT INTO `sub_task` (`sub_task_id`, `sub_task_name`) VALUES
(1, 'Ver vídeo aulas'),
(2, 'Consultar material no site'),
(3, '4 de abril'),
(4, 'Ouvir A-YO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `task`
--

CREATE TABLE `task` (
  `taskid` bigint(20) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `priority` varchar(255) DEFAULT NULL,
  `status_task` bit(1) NOT NULL,
  `task_details` varchar(255) DEFAULT NULL,
  `task_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `task`
--

INSERT INTO `task` (`taskid`, `category`, `priority`, `status_task`, `task_details`, `task_name`) VALUES
(1, 'sem categoria', 'MEDIA', b'0', 'Capitulo 4, 5 e 6', 'Estudar Lógica'),
(2, 'sem categoria', 'MEDIA', b'0', 'Dia 15 de Setembro', 'Comprar ingresso Rock in Rio'),
(3, 'sem categoria', 'MEDIA', b'0', 'Melhor CD', 'Ouvir Joanne no iTunes');

-- --------------------------------------------------------

--
-- Estrutura da tabela `task_lista_sub_tarefas`
--

CREATE TABLE `task_lista_sub_tarefas` (
  `task_taskid` bigint(20) NOT NULL,
  `lista_sub_tarefas_sub_task_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `task_lista_sub_tarefas`
--

INSERT INTO `task_lista_sub_tarefas` (`task_taskid`, `lista_sub_tarefas_sub_task_id`) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `user`
--

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_page` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `user`
--

INSERT INTO `user` (`user_id`, `user_email`, `user_name`, `user_page`) VALUES
(1, 'david.souza@ccc.ufcg.edu.br', 'David Souza', 'https://github.com/davidmedeiros');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sub_task`
--
ALTER TABLE `sub_task`
  ADD PRIMARY KEY (`sub_task_id`);

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`taskid`);

--
-- Indexes for table `task_lista_sub_tarefas`
--
ALTER TABLE `task_lista_sub_tarefas`
  ADD UNIQUE KEY `UK_n5sbgnfmeupfrimyydn577ffx` (`lista_sub_tarefas_sub_task_id`),
  ADD KEY `FK12cjq4oh3arxrxtsc8rvufk8l` (`task_taskid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sub_task`
--
ALTER TABLE `sub_task`
  MODIFY `sub_task_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `taskid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
