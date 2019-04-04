import com.google.gson.Gson;

import java.util.Vector;

public class Invoices implements JsonSupport {
	private Vector<Racun> racuns;
	public Vector<Racun> getracuns() {
		return racuns;
	}

	public void setracuns(Vector<Racun> racuns) {
		this.racuns = racuns;
	}

	public Invoices() {
		this.racuns = new Vector<Racun>();
	}

	public void Dodaj(Racun Racun){
		//compareTo za stringe

		racuns.add(Racun);
	}

	public String Odstrani(Racun Racun){
		this.racuns.remove(Racun);
		return "Odstranjen Racun: " + Racun;
	}

	public void OdstraniVse() {
		this.racuns.clear();
	}

	public void EditKolicina(Racun Racun, float kol){

	}
	public Invoices fromJson(String s) {
		Gson gson = new Gson();
		Invoices artikli = gson.fromJson(s, Invoices.class);
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
		for (Racun a: racuns) {
			Invoices += "Kolicina: " + '\n';
		}
		return Invoices;
	}
}
