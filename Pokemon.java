public class Pokemon {
	private String name;
	private int number;
	/**
	 * @Pokemon - default constructor
	 */
	public Pokemon(){
		name = null;
		number = 0;
	}
	/**
	 * @Pokemon - overloaded constructor
	 * @param name
	 * @param number
	 */
	public Pokemon(String name, int number){
		this.name = name;
		this.number = number;	
		}
	/**
	 * @setName - sets name for pokemon
	 * @param name
	 */
	public void setName(String name){
		this.name  = name;
	}
	/**
	 * @getName - returns name of pokemon
	 * @return
	 */
	public String getName(){
		return name;
	}
	/**
	 * @setNumber - sets number for pokemon
	 * @param number
	 */
	public void setNumber(int number){
		this.number = number;
	}
	/**
	 * @getNumber - returns number for pokemon
	 * @return
	 */
	public int getNumber(){
		return number;
	}
}
