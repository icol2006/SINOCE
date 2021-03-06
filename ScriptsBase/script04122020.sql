USE [BDSINOCE]
GO
/****** Object:  Table [dbo].[Curso]    Script Date: 04/12/2020 19:47:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Curso](
	[codCurso] [int] NOT NULL,
	[nombreCurso] [nvarchar](50) NOT NULL,
	[horasDuracionCurso] [int] NOT NULL,
 CONSTRAINT [PK_Curso] PRIMARY KEY CLUSTERED 
(
	[codCurso] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DatosPersona]    Script Date: 04/12/2020 19:47:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DatosPersona](
	[idPersona] [int] IDENTITY(1,1) NOT NULL,
	[cedPersona] [bigint] NOT NULL,
	[nombrePersona] [nvarchar](max) NULL,
	[apellido1] [nvarchar](max) NULL,
	[apellido2] [nvarchar](max) NULL,
	[correoPersonal] [nvarchar](max) NULL,
 CONSTRAINT [PK_datosPersona] PRIMARY KEY CLUSTERED 
(
	[idPersona] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Estudiante]    Script Date: 04/12/2020 19:47:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Estudiante](
	[idEstudiante] [int] IDENTITY(1,1) NOT NULL,
	[carneEstudiante] [nvarchar](50) NOT NULL,
	[idPersona] [int] NOT NULL,
 CONSTRAINT [PK_Estudiante] PRIMARY KEY CLUSTERED 
(
	[idEstudiante] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Instituto]    Script Date: 04/12/2020 19:47:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Instituto](
	[idInstituto] [int] IDENTITY(1,1) NOT NULL,
	[cedJuridica] [bigint] NULL,
	[codSede] [bigint] NOT NULL,
	[nombreInstituto] [nvarchar](max) NOT NULL,
	[ubicacionInstituto] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_Instituto] PRIMARY KEY CLUSTERED 
(
	[idInstituto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Matricula]    Script Date: 04/12/2020 19:47:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Matricula](
	[idMatricula] [bigint] IDENTITY(1,1) NOT NULL,
	[periodoMatricula] [nchar](10) NOT NULL,
	[codCurso] [int] NOT NULL,
	[idEstudiante] [int] NOT NULL,
	[idInstituto] [int] NOT NULL,
	[fechaInicio] [date] NOT NULL,
	[fechaConclusion] [date] NOT NULL,
 CONSTRAINT [CF_Matri_Curso] PRIMARY KEY CLUSTERED 
(
	[idMatricula] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Nota]    Script Date: 04/12/2020 19:47:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Nota](
	[idNota] [int] IDENTITY(1,1) NOT NULL,
	[idEstudiante] [int] NULL,
	[codCurso] [int] NULL,
	[calificacion] [int] NULL,
 CONSTRAINT [PK_Nota] PRIMARY KEY CLUSTERED 
(
	[idNota] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ProfesorCurso]    Script Date: 04/12/2020 19:47:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProfesorCurso](
	[idProfesor] [int] NOT NULL,
	[codCurso] [int] NOT NULL,
	[periodo] [nchar](10) NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Profesores]    Script Date: 04/12/2020 19:47:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Profesores](
	[idProfesor] [int] IDENTITY(1,1) NOT NULL,
	[especialidadProfesor] [nvarchar](max) NOT NULL,
	[profesionProfesor] [nvarchar](max) NOT NULL,
	[idPersona] [int] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Usuarios]    Script Date: 04/12/2020 19:47:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuarios](
	[usuario] [bigint] NOT NULL,
	[contrasenia] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Usuarios] PRIMARY KEY CLUSTERED 
(
	[usuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Curso] ([codCurso], [nombreCurso], [horasDuracionCurso]) VALUES (4, N'Filosofia', 45)
INSERT [dbo].[Curso] ([codCurso], [nombreCurso], [horasDuracionCurso]) VALUES (5, N'Ciencias 4', 40)
INSERT [dbo].[Curso] ([codCurso], [nombreCurso], [horasDuracionCurso]) VALUES (6, N'Sociales', 45)
INSERT [dbo].[Curso] ([codCurso], [nombreCurso], [horasDuracionCurso]) VALUES (33, N'Matematicas', 23)
INSERT [dbo].[Curso] ([codCurso], [nombreCurso], [horasDuracionCurso]) VALUES (43, N'Fisica', 4)
INSERT [dbo].[Curso] ([codCurso], [nombreCurso], [horasDuracionCurso]) VALUES (53, N'Redes', 45)
INSERT [dbo].[Curso] ([codCurso], [nombreCurso], [horasDuracionCurso]) VALUES (4544, N'Agricultura', 43)
SET IDENTITY_INSERT [dbo].[DatosPersona] ON 

INSERT [dbo].[DatosPersona] ([idPersona], [cedPersona], [nombrePersona], [apellido1], [apellido2], [correoPersonal]) VALUES (1, 5, N'Julio', N'Alvarez', N'Saborio', N'julio@gmail.com')
INSERT [dbo].[DatosPersona] ([idPersona], [cedPersona], [nombrePersona], [apellido1], [apellido2], [correoPersonal]) VALUES (2, 2, N'Gonzalo', N'Rivera', N'Vargas', N'gonzalo@gmail.com')
INSERT [dbo].[DatosPersona] ([idPersona], [cedPersona], [nombrePersona], [apellido1], [apellido2], [correoPersonal]) VALUES (3, 4838, N'Roberto', N'Trejos', N'Barrantes', N'roberto@gmail.com')
INSERT [dbo].[DatosPersona] ([idPersona], [cedPersona], [nombrePersona], [apellido1], [apellido2], [correoPersonal]) VALUES (4, 9, N'Vanessa', N'Acuna', N'Esquivel', N'vannesa@gmail.com')
INSERT [dbo].[DatosPersona] ([idPersona], [cedPersona], [nombrePersona], [apellido1], [apellido2], [correoPersonal]) VALUES (5, 43898, N'Marcos', N'Solis', N'Oreamuno', N'marcos@gmail.com')
INSERT [dbo].[DatosPersona] ([idPersona], [cedPersona], [nombrePersona], [apellido1], [apellido2], [correoPersonal]) VALUES (6, 3489, N'Mario', N'Servantes', N'Gutierrez', N'mario@gmail.com')
INSERT [dbo].[DatosPersona] ([idPersona], [cedPersona], [nombrePersona], [apellido1], [apellido2], [correoPersonal]) VALUES (7, 434, N'Jose', N'Acosta', N'Benavides', N'jose@gmail.com')
INSERT [dbo].[DatosPersona] ([idPersona], [cedPersona], [nombrePersona], [apellido1], [apellido2], [correoPersonal]) VALUES (8, 434, N'Carlos', N'Navarro', N'Segura', N'carlos@gmail.com')
INSERT [dbo].[DatosPersona] ([idPersona], [cedPersona], [nombrePersona], [apellido1], [apellido2], [correoPersonal]) VALUES (9, 4390, N'Teresa', N'Jimenez', N'Rojas', N'teresa@gmail.com')
INSERT [dbo].[DatosPersona] ([idPersona], [cedPersona], [nombrePersona], [apellido1], [apellido2], [correoPersonal]) VALUES (10, 3893498, N'Berta', N'Dinarte', N'Fernandez', N'berta@gmail.com')
INSERT [dbo].[DatosPersona] ([idPersona], [cedPersona], [nombrePersona], [apellido1], [apellido2], [correoPersonal]) VALUES (11, 3448, N'Daniela', N'Urena', N'Mendez', N'daniela@gmail.com')
INSERT [dbo].[DatosPersona] ([idPersona], [cedPersona], [nombrePersona], [apellido1], [apellido2], [correoPersonal]) VALUES (12, 4389843, N'Marta', N'Sanchez', N'Rusi', N'marta@gmail.com')
SET IDENTITY_INSERT [dbo].[DatosPersona] OFF
SET IDENTITY_INSERT [dbo].[Estudiante] ON 

INSERT [dbo].[Estudiante] ([idEstudiante], [carneEstudiante], [idPersona]) VALUES (1, N'10989', 1)
INSERT [dbo].[Estudiante] ([idEstudiante], [carneEstudiante], [idPersona]) VALUES (2, N'2', 2)
INSERT [dbo].[Estudiante] ([idEstudiante], [carneEstudiante], [idPersona]) VALUES (4, N'090', 4)
INSERT [dbo].[Estudiante] ([idEstudiante], [carneEstudiante], [idPersona]) VALUES (5, N'8394ad', 5)
INSERT [dbo].[Estudiante] ([idEstudiante], [carneEstudiante], [idPersona]) VALUES (6, N'8439', 6)
SET IDENTITY_INSERT [dbo].[Estudiante] OFF
SET IDENTITY_INSERT [dbo].[Instituto] ON 

INSERT [dbo].[Instituto] ([idInstituto], [cedJuridica], [codSede], [nombreInstituto], [ubicacionInstituto]) VALUES (1, 34344, 1, N'Instituto 1', N'Alajuela')
INSERT [dbo].[Instituto] ([idInstituto], [cedJuridica], [codSede], [nombreInstituto], [ubicacionInstituto]) VALUES (2, 54353, 2, N'Instituto 2', N'u2 ñlajskl adslñkj')
INSERT [dbo].[Instituto] ([idInstituto], [cedJuridica], [codSede], [nombreInstituto], [ubicacionInstituto]) VALUES (4, 43345, 3, N'Instituto 3', N'3 fdslakj lk')
INSERT [dbo].[Instituto] ([idInstituto], [cedJuridica], [codSede], [nombreInstituto], [ubicacionInstituto]) VALUES (5, 4334, 43445, N'Instituto 4', N'klj')
INSERT [dbo].[Instituto] ([idInstituto], [cedJuridica], [codSede], [nombreInstituto], [ubicacionInstituto]) VALUES (6, 344900, 43090, N'Instituto 5', N'ubi')
INSERT [dbo].[Instituto] ([idInstituto], [cedJuridica], [codSede], [nombreInstituto], [ubicacionInstituto]) VALUES (7, 4334, 3090, N'Instituto 6', N'lkj ddklj')
SET IDENTITY_INSERT [dbo].[Instituto] OFF
SET IDENTITY_INSERT [dbo].[Matricula] ON 

INSERT [dbo].[Matricula] ([idMatricula], [periodoMatricula], [codCurso], [idEstudiante], [idInstituto], [fechaInicio], [fechaConclusion]) VALUES (2, N'alkjl     ', 4, 1, 1, CAST(N'2020-12-03' AS Date), CAST(N'2020-12-03' AS Date))
INSERT [dbo].[Matricula] ([idMatricula], [periodoMatricula], [codCurso], [idEstudiante], [idInstituto], [fechaInicio], [fechaConclusion]) VALUES (11, N'Semestre 1', 4, 5, 1, CAST(N'2004-08-02' AS Date), CAST(N'2005-02-02' AS Date))
INSERT [dbo].[Matricula] ([idMatricula], [periodoMatricula], [codCurso], [idEstudiante], [idInstituto], [fechaInicio], [fechaConclusion]) VALUES (13, N'Semestre 1', 4, 6, 7, CAST(N'2004-08-02' AS Date), CAST(N'2005-02-02' AS Date))
INSERT [dbo].[Matricula] ([idMatricula], [periodoMatricula], [codCurso], [idEstudiante], [idInstituto], [fechaInicio], [fechaConclusion]) VALUES (14, N'2005      ', 33, 5, 2, CAST(N'2005-02-02' AS Date), CAST(N'2005-04-02' AS Date))
INSERT [dbo].[Matricula] ([idMatricula], [periodoMatricula], [codCurso], [idEstudiante], [idInstituto], [fechaInicio], [fechaConclusion]) VALUES (15, N'002       ', 53, 5, 6, CAST(N'2020-03-03' AS Date), CAST(N'2020-05-03' AS Date))
INSERT [dbo].[Matricula] ([idMatricula], [periodoMatricula], [codCurso], [idEstudiante], [idInstituto], [fechaInicio], [fechaConclusion]) VALUES (16, N'2020      ', 4, 1, 5, CAST(N'2020-03-02' AS Date), CAST(N'2024-03-02' AS Date))
INSERT [dbo].[Matricula] ([idMatricula], [periodoMatricula], [codCurso], [idEstudiante], [idInstituto], [fechaInicio], [fechaConclusion]) VALUES (17, N'2020      ', 4, 4, 5, CAST(N'2020-03-02' AS Date), CAST(N'2024-03-02' AS Date))
INSERT [dbo].[Matricula] ([idMatricula], [periodoMatricula], [codCurso], [idEstudiante], [idInstituto], [fechaInicio], [fechaConclusion]) VALUES (18, N'2020      ', 4, 6, 1, CAST(N'2020-03-02' AS Date), CAST(N'2020-04-02' AS Date))
SET IDENTITY_INSERT [dbo].[Matricula] OFF
SET IDENTITY_INSERT [dbo].[Nota] ON 

INSERT [dbo].[Nota] ([idNota], [idEstudiante], [codCurso], [calificacion]) VALUES (3, 1, 4, 45)
INSERT [dbo].[Nota] ([idNota], [idEstudiante], [codCurso], [calificacion]) VALUES (4, 5, 4, 88)
SET IDENTITY_INSERT [dbo].[Nota] OFF
INSERT [dbo].[ProfesorCurso] ([idProfesor], [codCurso], [periodo]) VALUES (2, 4, N'Primero   ')
INSERT [dbo].[ProfesorCurso] ([idProfesor], [codCurso], [periodo]) VALUES (3, 5, N'Segundo   ')
INSERT [dbo].[ProfesorCurso] ([idProfesor], [codCurso], [periodo]) VALUES (2, 43, N'2002      ')
INSERT [dbo].[ProfesorCurso] ([idProfesor], [codCurso], [periodo]) VALUES (5, 53, N'2006      ')
SET IDENTITY_INSERT [dbo].[Profesores] ON 

INSERT [dbo].[Profesores] ([idProfesor], [especialidadProfesor], [profesionProfesor], [idPersona]) VALUES (2, N'esp4', N'prof4', 9)
INSERT [dbo].[Profesores] ([idProfesor], [especialidadProfesor], [profesionProfesor], [idPersona]) VALUES (3, N'esp3', N'pro3', 10)
INSERT [dbo].[Profesores] ([idProfesor], [especialidadProfesor], [profesionProfesor], [idPersona]) VALUES (4, N'esp2', N'pro2', 11)
INSERT [dbo].[Profesores] ([idProfesor], [especialidadProfesor], [profesionProfesor], [idPersona]) VALUES (5, N'es1', N'pr1', 12)
SET IDENTITY_INSERT [dbo].[Profesores] OFF
INSERT [dbo].[Usuarios] ([usuario], [contrasenia]) VALUES (112233, N'112233    ')
/****** Object:  Index [PK_Profesores]    Script Date: 04/12/2020 19:47:10 ******/
ALTER TABLE [dbo].[Profesores] ADD  CONSTRAINT [PK_Profesores] PRIMARY KEY NONCLUSTERED 
(
	[idProfesor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Estudiante]  WITH CHECK ADD  CONSTRAINT [FK_Estudiante_DatosPersona] FOREIGN KEY([idPersona])
REFERENCES [dbo].[DatosPersona] ([idPersona])
GO
ALTER TABLE [dbo].[Estudiante] CHECK CONSTRAINT [FK_Estudiante_DatosPersona]
GO
ALTER TABLE [dbo].[Matricula]  WITH CHECK ADD  CONSTRAINT [FK_Matricula_Curso] FOREIGN KEY([codCurso])
REFERENCES [dbo].[Curso] ([codCurso])
GO
ALTER TABLE [dbo].[Matricula] CHECK CONSTRAINT [FK_Matricula_Curso]
GO
ALTER TABLE [dbo].[Matricula]  WITH CHECK ADD  CONSTRAINT [FK_Matricula_Estudiante] FOREIGN KEY([idEstudiante])
REFERENCES [dbo].[Estudiante] ([idEstudiante])
GO
ALTER TABLE [dbo].[Matricula] CHECK CONSTRAINT [FK_Matricula_Estudiante]
GO
ALTER TABLE [dbo].[Matricula]  WITH CHECK ADD  CONSTRAINT [FK_Matricula_Instituto] FOREIGN KEY([idInstituto])
REFERENCES [dbo].[Instituto] ([idInstituto])
GO
ALTER TABLE [dbo].[Matricula] CHECK CONSTRAINT [FK_Matricula_Instituto]
GO
ALTER TABLE [dbo].[Nota]  WITH CHECK ADD  CONSTRAINT [FK_Nota_Curso] FOREIGN KEY([codCurso])
REFERENCES [dbo].[Curso] ([codCurso])
GO
ALTER TABLE [dbo].[Nota] CHECK CONSTRAINT [FK_Nota_Curso]
GO
ALTER TABLE [dbo].[Nota]  WITH CHECK ADD  CONSTRAINT [FK_Nota_Estudiante] FOREIGN KEY([idEstudiante])
REFERENCES [dbo].[Estudiante] ([idEstudiante])
GO
ALTER TABLE [dbo].[Nota] CHECK CONSTRAINT [FK_Nota_Estudiante]
GO
ALTER TABLE [dbo].[ProfesorCurso]  WITH CHECK ADD  CONSTRAINT [FK_ProfesorCurso_Curso] FOREIGN KEY([codCurso])
REFERENCES [dbo].[Curso] ([codCurso])
GO
ALTER TABLE [dbo].[ProfesorCurso] CHECK CONSTRAINT [FK_ProfesorCurso_Curso]
GO
ALTER TABLE [dbo].[ProfesorCurso]  WITH CHECK ADD  CONSTRAINT [FK_ProfesorCurso_Profesores] FOREIGN KEY([idProfesor])
REFERENCES [dbo].[Profesores] ([idProfesor])
GO
ALTER TABLE [dbo].[ProfesorCurso] CHECK CONSTRAINT [FK_ProfesorCurso_Profesores]
GO
ALTER TABLE [dbo].[Profesores]  WITH CHECK ADD  CONSTRAINT [FK_Profesores_DatosPersona] FOREIGN KEY([idPersona])
REFERENCES [dbo].[DatosPersona] ([idPersona])
GO
ALTER TABLE [dbo].[Profesores] CHECK CONSTRAINT [FK_Profesores_DatosPersona]
GO
