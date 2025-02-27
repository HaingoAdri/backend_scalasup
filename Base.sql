CREATE TABLE Admin (
    idAdmin SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE Universite (
    idUniversite SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    adresse TEXT NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    idAdmin INT REFERENCES Admin(idAdmin) ON DELETE SET NULL
);

CREATE TABLE Etudiant (
    idEtudiant SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    dateNaissance DATE NOT NULL,
    password VARCHAR(255) NOT NULL
);


CREATE TABLE Abonnement (
    idAbonnement SERIAL PRIMARY KEY,
    type VARCHAR(100) NOT NULL,
    dateDebut DATE NOT NULL,
    dateExpiration DATE NOT NULL,
    idUniversite INT REFERENCES Universite(idUniversite) ON DELETE CASCADE
);

CREATE TABLE Publicite (
    idPublicite SERIAL PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    campagne VARCHAR(255) NOT NULL,
    idUniversite INT REFERENCES Universite(idUniversite) ON DELETE CASCADE
);

CREATE TABLE Formation (
    idFormation SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    idUniversite INT REFERENCES Universite(idUniversite) ON DELETE CASCADE
);

CREATE TABLE Candidature (
    idCandidature SERIAL PRIMARY KEY,
    statut VARCHAR(100) NOT NULL,
    dateSoumission DATE NOT NULL,
    idEtudiant INT REFERENCES Etudiant(idEtudiant) ON DELETE CASCADE,
    idUniversite INT REFERENCES Universite(idUniversite) ON DELETE CASCADE
);

CREATE TABLE Paiement (
    idPaiement SERIAL PRIMARY KEY,
    montant DECIMAL(10,2) NOT NULL,
    date DATE NOT NULL,
    statut VARCHAR(100) NOT NULL,
    idEtudiant INT REFERENCES Etudiant(idEtudiant) ON DELETE CASCADE
);

CREATE TABLE Facture (
    idFacture SERIAL PRIMARY KEY,
    numero VARCHAR(50) UNIQUE NOT NULL,
    montant DECIMAL(10,2) NOT NULL,
    dateEmission DATE NOT NULL,
    dateEcheance DATE NOT NULL,
    idEtudiant INT REFERENCES Etudiant(idEtudiant) ON DELETE CASCADE
);

CREATE TABLE Formulaire (
    idFormulaire SERIAL PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    idUniversite INT REFERENCES Universite(idUniversite) ON DELETE CASCADE
);

CREATE TABLE Champ (
    idChamp SERIAL PRIMARY KEY,
    type VARCHAR(100) NOT NULL,
    question TEXT NOT NULL,
    obligatoire BOOLEAN NOT NULL,
    idFormulaire INT REFERENCES Formulaire(idFormulaire) ON DELETE CASCADE
);

CREATE TABLE Reponse (
    idReponse SERIAL PRIMARY KEY,
    valeur TEXT NOT NULL,
    idChamp INT REFERENCES Champ(idChamp) ON DELETE CASCADE
);

CREATE TABLE Article (
    idArticle SERIAL PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    contenu TEXT NOT NULL,
    datePublication DATE NOT NULL,
    idUniversite INT REFERENCES Universite(idUniversite) ON DELETE CASCADE
);

CREATE TABLE Etat (
    idEtat SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    description TEXT NOT NULL
);

CREATE TABLE Messagerie (
    idMessage SERIAL PRIMARY KEY,
    expediteur VARCHAR(255) NOT NULL,
    destinataire VARCHAR(255) NOT NULL,
    contenu TEXT NOT NULL,
    dateEnvoi DATE NOT NULL,
    lu BOOLEAN DEFAULT FALSE,
    idEtudiantExp INT REFERENCES Etudiant(idEtudiant) ON DELETE CASCADE,
    idEtudiantDest INT REFERENCES Etudiant(idEtudiant) ON DELETE CASCADE
);

CREATE TABLE Notification (
    idNotification SERIAL PRIMARY KEY,
    type VARCHAR(100) NOT NULL,
    message TEXT NOT NULL,
    dateNotification DATE NOT NULL,
    lue BOOLEAN DEFAULT FALSE,
    idEtudiant INT REFERENCES Etudiant(idEtudiant) ON DELETE CASCADE
);

CREATE TABLE Fichier (
    idFichier SERIAL PRIMARY KEY,
    nomFichier VARCHAR(255) NOT NULL,
    typeFichier VARCHAR(100) NOT NULL,
    tailleFichier INT NOT NULL,
    dateTelechargement DATE NOT NULL,
    idEtudiant INT REFERENCES Etudiant(idEtudiant) ON DELETE CASCADE
);

connexion base 
psql -h aws-0-ap-southeast-1.pooler.supabase.com -p 6543 -d postgres -U postgres.efyyxkvshmhfbrprzhqs