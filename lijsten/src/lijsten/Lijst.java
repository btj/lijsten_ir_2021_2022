package lijsten;

public abstract class Lijst<T> {

	public abstract int getLength();
	
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			Lijst<T> lijst = Lijst.this;
			
			@Override
			public boolean hasNext() {
				return lijst instanceof NietLegeLijst;
			}
			
			@Override
			public T next() {
				NietLegeLijst<T> nll = (NietLegeLijst<T>)lijst;
				lijst = nll.getStaart();
				return nll.getKop();
			}
		};
	}
	
	public void forEach(Consumer<? super T> consumer) {
		Lijst<T> lijst = this;
		for (;;) {
			if (lijst instanceof NietLegeLijst<T> nll) {
				consumer.accept(nll.getKop());
				lijst = nll.getStaart();
			} else
				break;
		}
	}
	
}
