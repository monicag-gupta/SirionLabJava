package first;
import java.util.Scanner;
interface Animal{
	void eat();
}
interface LivingBeings{
	void breathe();
}
class Mammal{
	private String bones="Vertebrates"; 
	// bones is encapsulated (Hidden) : can be used only within the class
	public void handbones() {
		System.out.println("Publically available handbones");
	}//handbones() is abstracted  : can be used as a library too
	protected void print() { 
		//print() is encapsulated(protected) : can be used within the package, sub classes in other packages
		System.out.println(bones);
	}
	void display() {
		//display() is encapsulated(default) : can be used within the package 
		System.out.println("Displaying a mammal"); 
	}
}
class Human extends Mammal implements Animal, LivingBeings{ //hybrid Inheritance : extension, implementation
	//Multiple Inheritance
	public void handbones() {
		System.out.println("Human working");
	}
	public void breathe() {
		System.out.println("Humans breathe");
	}
	public void eat() {
		System.out.println("Humans eat");
	}
}
class Bat extends Mammal{ //single Inheritance
	public void handbones() {
		System.out.println("Bat Flying");
	}
}
class Bony{
	public String str="Birds Fly high"; 
}
class Hairy{
	public String str="Insects Fly low"; 
}
class FlyingAnimals{
	public void wings(Bony b) {
		System.out.println(b.str);
	}
	public void wings(Hairy b) {
		System.out.println(b.str);
	}
}
public class OOPSMain {
	public Mammal ObjMammal() {
		Mammal m=new Mammal();
		Scanner sc=new Scanner(System.in);
		System.out.println("What do you see?(Humman/Bat)?");
		String s=sc.nextLine();
		sc.close();
		if(s.equals("Bat")) {
			m=new Bat();
		}
		else if(s.equals("Human"))
			m=new Human();
		return m;
	}

	public static void main(String[] args) {
		Mammal m=new OOPSMain().ObjMammal();
		m.handbones(); //overriding// we do not know if the handbones() are of human or bat until runtime
		FlyingAnimals ani=new FlyingAnimals();
		ani.wings(new Bony()); //overloading
		ani.wings(new Hairy()); //overloading

	}

}
