import java.io.PrintWriter;
public class report {

	private Artist first;
	private Artist last;

	class Artist {

		private String name;
		private Artist next;

		// for class Artist
		public Artist(String name) {

			this.name = name;
			this.next = null;
		}
	}

	public report() {

		first = null;
		last = null;
	}

	public boolean isEmpty() {

		return (first == null);
	}

	// insert method
	void add(String name) {

		Artist newArtist = new Artist(name);

		if (this.isEmpty()) {

			first = newArtist;
			last = newArtist;

		} else {

			last.next = newArtist;
			last = newArtist;
		}
	}

	public void sortList() {
		Artist pos = first, index = null;
		String temp; 

		if (this.isEmpty()) {
			
			return;

		} else {

			while (pos != null) {
				index = pos.next;
				while (index != null) {
					if (pos.name.compareTo(index.name) > 0) {
						temp = pos.name;
						pos.name = index.name;
						index.name = temp;
					}
					index = index.next; 
				}
				pos = pos.next; 
			}
		}
	}

	public void displayNames() throws Exception{
		PrintWriter outputFile = new PrintWriter("Lab3Output.txt");

		Artist current = first;

		this.sortList(); 

		if (this.isEmpty()) {    
			outputFile.println("List is empty");
			outputFile.close();
			return;
		}

		while (current != null) {
			outputFile.println(current.name);
			current = current.next;            
		}       
		outputFile.close();
	}

	public static void main(String[] args) throws Exception {

		report Names = new report();

		Names.add("Eminem");
		Names.add("Usher");
		Names.add("Michael Jackson");
		Names.add("Remy Ma");
		Names.add("Chris Brown");
		Names.add("Bruno Mars");
		Names.add("Jay-z");
		Names.add("Beyonce");
		Names.add("Nicki Minaj");
		Names.add("Kanye West");
		Names.add("Kendrick Lamar");
		Names.add("Major Lazer");
		Names.add("Calvin Harris");
		Names.add("Maroon 5");
		Names.add("John Legend");
		Names.add("Alicia Keys");
		Names.displayNames();      
	}
}
