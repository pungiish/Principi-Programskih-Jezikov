import com.google.gson.Gson;

import java.util.Vector;

public class Companies implements JsonSupport {
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
	public Companies fromJson(String s) {
		Gson gson = new Gson();
		Companies artikli = gson.fromJson(s, Companies.class);
		return artikli;
	}

	public String toJson() {
		Gson gson = new Gson();
		String json = gson.toJson(this);
		return json;
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
