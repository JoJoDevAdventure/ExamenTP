
public class Poste {
    public static void main(String[] args) {
        Lettre lettre =new Lettre("Tozeur", "Tunis", 20.0, TypeLettre.Prioritaire);
        Lettre lettre2 =new Lettre("Sfax", "Sousse", 25.0, TypeLettre.Ordinaire);
        Colis colis = new Colis("Tunisie", "France", 5000.0);

        System.out.println(lettre.toString()); 
        System.out.println(lettre2.toString());
        System.out.println(colis.toString());
    }
}

enum TypeLettre {
    Prioritaire, Ordinaire
}

abstract class Courrier {
    String adresseDestination ;
    String adressExpedition ;
    Double poid ;

    Courrier (String adresseDestination, String adressExpedition, Double poid) {
        this.adressExpedition = adressExpedition ;
        this.adresseDestination = adresseDestination ;
        this.poid = poid ;
    }

    abstract Double CalculTimbre();

    public String ToString() {
        return "Expéditeur : " + adressExpedition + " Destinataire : " + adresseDestination + " Poid : " + poid + " Cour Time = " + CalculTimbre() ;
    }
}

class Colis extends Courrier {

    Colis(String adresseDestination, String adressExpedition, Double poid) {
        super(adresseDestination, adressExpedition, poid);
    }

    @Override
    Double CalculTimbre() {
        Double tarif = 5000.0 ;
        if (this.poid > 2000) {
            return (((this.poid / 1000) - 2) * 1800 );
        } else {
            return tarif;
        }
    }

    @Override
    public String toString() {
        return "Expéditeur : " + adressExpedition + " Destinataire : " + adresseDestination + " Poid : " + poid + " Cour Time = " + CalculTimbre();
    }
}

class Lettre extends Courrier {

    TypeLettre type;

    Lettre(String adresseDestination, String adressExpedition, Double poid, TypeLettre type) {
        super(adresseDestination, adressExpedition, poid);
        this.type = type;
    }

    @Override
    Double CalculTimbre() {
        if (this.poid < 20) {
            if (type == TypeLettre.Prioritaire) {
                return 1500.0 ;
            } else {
                return 1000.0 ;
            }
        } else if (this.poid > 20 && this.poid < 250) {
            return 1200.0 ;
        } else if (this.poid > 250 && this.poid < 1000) {
            return 2000.0 ;
        } else {
            return 2800.0 ;
        }
    }

    @Override
    public String toString() {
        return "Courrier " + type.toString() + " " + "Expéditeur : " + adressExpedition + " Destinataire : " + adresseDestination + " Poid : " + poid + " Cour Time = " + CalculTimbre() ;
    }
}