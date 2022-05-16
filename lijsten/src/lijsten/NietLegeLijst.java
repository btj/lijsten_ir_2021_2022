package lijsten;

public class NietLegeLijst<T> extends Lijst<T> {

	private T kop;
	private Lijst<T> staart;
	
	public T getKop() { return kop; }
	public Lijst<T> getStaart() { return staart; }
	
	public NietLegeLijst(T kop, Lijst<T> staart) {
		this.kop = kop;
		this.staart = staart;
	}
	
	@Override
	public int getLength() {
		return 1 + staart.getLength();
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof NietLegeLijst<?> nll &&
				kop == nll.kop &&
				staart.equals(nll.staart);
	}
	
	@Override
	public String toString() {
		return "[" + kop +
				(staart instanceof LegeLijst ? "]" :
					", " + staart.toString().substring(1));
	}
	
}
