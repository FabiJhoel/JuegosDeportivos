USE [master]
GO
/****** Object:  Database [JuegosDeportivos]    Script Date: 02/05/2014 14:36:05 ******/
CREATE DATABASE [JuegosDeportivos]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'JuegosDeportivos', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\JuegosDeportivos.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'JuegosDeportivos_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\JuegosDeportivos_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [JuegosDeportivos] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [JuegosDeportivos].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [JuegosDeportivos] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET ARITHABORT OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [JuegosDeportivos] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [JuegosDeportivos] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [JuegosDeportivos] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET  DISABLE_BROKER 
GO
ALTER DATABASE [JuegosDeportivos] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [JuegosDeportivos] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET RECOVERY FULL 
GO
ALTER DATABASE [JuegosDeportivos] SET  MULTI_USER 
GO
ALTER DATABASE [JuegosDeportivos] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [JuegosDeportivos] SET DB_CHAINING OFF 
GO
ALTER DATABASE [JuegosDeportivos] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [JuegosDeportivos] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'JuegosDeportivos', N'ON'
GO
USE [JuegosDeportivos]
GO
/****** Object:  Table [dbo].[Alojamientos]    Script Date: 02/05/2014 14:36:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Alojamientos](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
	[direccion] [varchar](50) NULL,
 CONSTRAINT [PK_Alojamientos] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Competidores]    Script Date: 02/05/2014 14:36:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Competidores](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[pais] [char](4) NULL,
	[nombre] [varchar](50) NULL,
	[genero] [bit] NULL,
	[entrenador] [varchar](50) NULL,
	[tipo] [bit] NULL,
	[idAlojamiento] [int] NOT NULL,
 CONSTRAINT [PK_Competidores] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CompetidorEventos]    Script Date: 02/05/2014 14:36:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CompetidorEventos](
	[idCompetidor] [int] NOT NULL,
	[idEvento] [int] NULL,
	[mejorMarca] [float] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CompetidorSeries]    Script Date: 02/05/2014 14:36:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CompetidorSeries](
	[idSerie] [int] NOT NULL,
	[idCompetidor] [int] NOT NULL,
	[resultado] [varchar](50) NULL,
	[posicionSerie] [int] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Equipos]    Script Date: 02/05/2014 14:36:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Equipos](
	[idCompetidor] [int] NOT NULL,
	[telContacto] [varchar](50) NULL,
	[emailContacto] [varchar](50) NULL,
 CONSTRAINT [PK_Equipos] PRIMARY KEY CLUSTERED 
(
	[idCompetidor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Eventos]    Script Date: 02/05/2014 14:36:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Eventos](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[modalidad] [bit] NULL,
	[genero] [bit] NULL,
	[fechaInicio] [date] NULL,
	[fechaFinal] [date] NULL,
	[metrica] [varchar](50) NULL,
	[rangoMin] [float] NULL,
	[rangoMax] [float] NULL,
	[capacidadMax] [int] NULL,
	[idInstalacion] [int] NOT NULL,
	[nombre] [varchar](50) NULL,
 CONSTRAINT [PK_Eventos] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Facilidades]    Script Date: 02/05/2014 14:36:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Facilidades](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](50) NULL,
	[idAlojamiento] [int] NOT NULL,
 CONSTRAINT [PK_Facilidades] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[IndividuoEquipos]    Script Date: 02/05/2014 14:36:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[IndividuoEquipos](
	[idEquipo] [int] NOT NULL,
	[idIndividuo] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Individuos]    Script Date: 02/05/2014 14:36:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Individuos](
	[idCompetidor] [int] NOT NULL,
	[apellido1] [varchar](50) NULL,
	[apellido2] [varchar](50) NULL,
	[fechaNac] [date] NULL,
	[ocupacion] [varchar](50) NULL,
	[ciudad] [varchar](50) NULL,
	[edad] [int] NULL,
 CONSTRAINT [PK_Individuos] PRIMARY KEY CLUSTERED 
(
	[idCompetidor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Instalaciones]    Script Date: 02/05/2014 14:36:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Instalaciones](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
	[direccion] [varchar](50) NULL,
	[cantAsientos] [int] NULL,
 CONSTRAINT [PK_Instalaciones] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Series]    Script Date: 02/05/2014 14:36:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Series](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[cantMax] [int] NULL,
	[idEvento] [int] NOT NULL,
	[descripcion] [varchar](50) NULL,
 CONSTRAINT [PK_Series] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Competidores]  WITH CHECK ADD  CONSTRAINT [FK_Competidores_Alojamientos] FOREIGN KEY([idAlojamiento])
REFERENCES [dbo].[Alojamientos] ([id])
GO
ALTER TABLE [dbo].[Competidores] CHECK CONSTRAINT [FK_Competidores_Alojamientos]
GO
ALTER TABLE [dbo].[CompetidorEventos]  WITH CHECK ADD  CONSTRAINT [FK_CompetidorEventos_Competidores] FOREIGN KEY([idCompetidor])
REFERENCES [dbo].[Competidores] ([id])
GO
ALTER TABLE [dbo].[CompetidorEventos] CHECK CONSTRAINT [FK_CompetidorEventos_Competidores]
GO
ALTER TABLE [dbo].[CompetidorEventos]  WITH CHECK ADD  CONSTRAINT [FK_CompetidorEventos_Eventos] FOREIGN KEY([idEvento])
REFERENCES [dbo].[Eventos] ([id])
GO
ALTER TABLE [dbo].[CompetidorEventos] CHECK CONSTRAINT [FK_CompetidorEventos_Eventos]
GO
ALTER TABLE [dbo].[CompetidorSeries]  WITH CHECK ADD  CONSTRAINT [FK_CompetidorSeries_Competidores] FOREIGN KEY([idCompetidor])
REFERENCES [dbo].[Competidores] ([id])
GO
ALTER TABLE [dbo].[CompetidorSeries] CHECK CONSTRAINT [FK_CompetidorSeries_Competidores]
GO
ALTER TABLE [dbo].[CompetidorSeries]  WITH CHECK ADD  CONSTRAINT [FK_CompetidorSeries_Series] FOREIGN KEY([idSerie])
REFERENCES [dbo].[Series] ([id])
GO
ALTER TABLE [dbo].[CompetidorSeries] CHECK CONSTRAINT [FK_CompetidorSeries_Series]
GO
ALTER TABLE [dbo].[Equipos]  WITH CHECK ADD  CONSTRAINT [FK_Equipos_Competidores] FOREIGN KEY([idCompetidor])
REFERENCES [dbo].[Competidores] ([id])
GO
ALTER TABLE [dbo].[Equipos] CHECK CONSTRAINT [FK_Equipos_Competidores]
GO
ALTER TABLE [dbo].[Eventos]  WITH CHECK ADD  CONSTRAINT [FK_Eventos_Instalaciones] FOREIGN KEY([idInstalacion])
REFERENCES [dbo].[Instalaciones] ([id])
GO
ALTER TABLE [dbo].[Eventos] CHECK CONSTRAINT [FK_Eventos_Instalaciones]
GO
ALTER TABLE [dbo].[Facilidades]  WITH CHECK ADD  CONSTRAINT [FK_Facilidades_Alojamientos] FOREIGN KEY([idAlojamiento])
REFERENCES [dbo].[Alojamientos] ([id])
GO
ALTER TABLE [dbo].[Facilidades] CHECK CONSTRAINT [FK_Facilidades_Alojamientos]
GO
ALTER TABLE [dbo].[IndividuoEquipos]  WITH CHECK ADD  CONSTRAINT [FK_IndividuosEquipos_Equipos] FOREIGN KEY([idEquipo])
REFERENCES [dbo].[Equipos] ([idCompetidor])
GO
ALTER TABLE [dbo].[IndividuoEquipos] CHECK CONSTRAINT [FK_IndividuosEquipos_Equipos]
GO
ALTER TABLE [dbo].[IndividuoEquipos]  WITH CHECK ADD  CONSTRAINT [FK_IndividuosEquipos_Individuos] FOREIGN KEY([idIndividuo])
REFERENCES [dbo].[Individuos] ([idCompetidor])
GO
ALTER TABLE [dbo].[IndividuoEquipos] CHECK CONSTRAINT [FK_IndividuosEquipos_Individuos]
GO
ALTER TABLE [dbo].[Individuos]  WITH CHECK ADD  CONSTRAINT [FK_Individuos_Competidores] FOREIGN KEY([idCompetidor])
REFERENCES [dbo].[Competidores] ([id])
GO
ALTER TABLE [dbo].[Individuos] CHECK CONSTRAINT [FK_Individuos_Competidores]
GO
ALTER TABLE [dbo].[Series]  WITH CHECK ADD  CONSTRAINT [FK_Series_Eventos] FOREIGN KEY([idEvento])
REFERENCES [dbo].[Eventos] ([id])
GO
ALTER TABLE [dbo].[Series] CHECK CONSTRAINT [FK_Series_Eventos]
GO
USE [master]
GO
ALTER DATABASE [JuegosDeportivos] SET  READ_WRITE 
GO
