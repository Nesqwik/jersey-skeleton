DROP TABLE IF EXISTS commentaire;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS utilisateur;

CREATE TABLE commentaire (
	idCom int primary key,
	commentaire text,
	idPoste int,
	pseudo text,
	foreign key(pseudo) references utilisateur(pseudo),
	foreign key(idPost) references post(idPost)
);

CREATE TABLE post (
	idPost int primary key,
	description text,
	path text,
	pseudo text,
	foreign key(pseudo) references utilisateur(pseudo)
);

CREATE TABLE utilisateur (
	pseudo text primary key,
	mail text unique,
	mdp text, 
	admin int
);

