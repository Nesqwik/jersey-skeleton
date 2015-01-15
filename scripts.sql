DROP TABLE commentaire;
DROP TABLE fichier;
DROP TABLE post;
DROP TABLE utilisateur;
CREATE TABLE commentaire (idCom int primary key, commentaire text, idPoste int, mail text, foreign key(mail) references utilisateur(mail), foreign key(idPoste) references poste(idPoste));
CREATE TABLE fichier (nom text primary key, chemin text, date text, taille int, idPoste int, foreign key(idPoste) references poste(idPoste));
CREATE TABLE post (idPoste int primary key, description text, mail text, foreign key(mail) references utilisateur(mail));
CREATE TABLE utilisateur (mail text primary key, pseudo text unique, mdp text, admin int);

