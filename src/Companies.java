import java.util.Vector;

public class Companies {
	private Vector<Podjetje> podjetjas;

	public Companies() {
		this.podjetjas = new Vector<Podjetje>();
	}

	public Vector<Podjetje> getpodjetjas() {
		return podjetjas;
	}

	public void setpodjetjas(Vector<Podjetje> podjetjas) {
		this.podjetjas = podjetjas;
	}



	public void Dodaj(Podjetje Podjetje){
		//compareTo za stringe

		podjetjas.add(Podjetje);
	}

	public String Odstrani(Podjetje Podjetje){
		this.podjetjas.remove(Podjetje);
		return "Odstranjen Podjetje: " + Podjetje;
	}

	public void OdstraniVse() {
		this.podjetjas.clear();
	}

	public void EditKolicina(Podjetje Podjetje, float kol){

	}
	@Override
	public String toString() {
		String Invoices = "";
		for (Podjetje a: podjetjas) {
			Invoices += "Kolicina: " + '\n';
		}
		return Invoices;
	}

}
