package diagram01;

import java.util.Arrays;

public class Person implements Subscriber {
	private String name;
	private Readable[] readables = new Readable[100];

	public Person() {

	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Readable[] getReadables() {
		return readables;
	}

	public void setReadables(Readable[] readables) {
		this.readables = readables;
	}

	@Override
	public void update(Readable readable) {
		if (readbleExists(readable)) {
		} else {
			for (int index = 0; index < readables.length; index++) {
				if (readables[index] == null) {
					readables[index] = readable;
					index = readables.length;
				}
			}
		}
	}

	public void readAll() {
		for (Readable r : readables) {
			if (r != null) {
				r.read();
			}

		}
	}

	private boolean readbleExists(Readable readable) {

		for (Readable r : readables) {
			if (r == null) {
				return false;
			}

			if (r.equals(readable)) {
				return true;
			}
		}
		return false;
	}

	public void delete(Readable readable) {

		for (int index = 0; index < readables.length; index++) {
			if (readables[index].equals(readable)) {
				readables[index] = null;
				index = readables.length;
			}
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(readables);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(readables, other.readables))
			return false;
		return true;
	}
	
	
}
