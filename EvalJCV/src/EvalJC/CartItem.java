package EvalJC;

public class CartItem {

	private Item item;
	private Integer nbItem;
	
	
	public CartItem(Item item, Integer nbItem) {
		super();
		this.item = item;
		this.nbItem = nbItem;
	}


	public Item getItem() {
		return item;
	}
	public Integer getNbItem() {
		return nbItem;
	}


	public void setItem(Item item) {
		this.item = item;
	}
	public void setNbItem(Integer nbItem) {
		this.nbItem = nbItem;
	}
	
	
	
	
}
