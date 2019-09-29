import java.util.Map;
import java.util.LinkedHashMap;

public class ShoppingCart {

	public static void main(String[] args) {
		Cart keranjang = new Cart();
		keranjang.tambahProduk("Pisang Hijau", 2);
		keranjang.tambahProduk("Semangka Kuning", 3);
		keranjang.tambahProduk("Apel Merah", 1);
		keranjang.tambahProduk("Apel Merah", 4);
		keranjang.tambahProduk("Apel Merah", 2);
		keranjang.hapusProduk("Semangka Kuning");
		keranjang.hapusProduk("Semangka Merah");
		keranjang.tampilkanCart();
	}
}

class Cart {
	
	LinkedHashMap<String, Integer> cart;
	
	public Cart() {
		cart = new LinkedHashMap<String,Integer>();
	}
	
	public void tambahProduk(String kodeProduk, Integer kuantitas) {
		if(cart.containsKey(kodeProduk)) {
			int kuantitasBaru = cart.get(kodeProduk) + kuantitas;
			cart.put(kodeProduk, kuantitasBaru);
		}
		else {
			cart.put(kodeProduk, kuantitas);
		}
	}
	
	public void hapusProduk(String kodeProduk) {
		cart.remove(kodeProduk);
	}
	
	public void tampilkanCart() {
		for(Map.Entry<String, Integer> entry : cart.entrySet()) {
			System.out.println(entry.getKey() + " (" + entry.getValue() + ")");
		}
	}
}