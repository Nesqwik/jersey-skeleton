DROP TABLE IF EXISTS commentaire;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS utilisateur;

CREATE TABLE commentaire (
	idCom int primary key,
	commentaire text,
	idPoste int,
	mail text,
	foreign key(mail) references utilisateur(mail),
	foreign key(idPoste) references poste(idPoste)
);

CREATE TABLE post (
	idPost int primary key,
	description text,
	path text,
	mail text,
	foreign key(mail) references utilisateur(mail)
);

CREATE TABLE utilisateur (
	pseudo text primary key,
	mail text unique,
	mdp text, 
	admin int
);

