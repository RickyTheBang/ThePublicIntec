package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Eatable;

public interface WaffleSeller extends Profitable {
	Waffle orderWaffle();

	class Waffle implements Eatable {
		double prize;

		public Waffle() {

		}

		public Waffle(double prize) {

			this.prize = prize;
		}

		public double getPrize() {
			return prize;
		}

		public void setPrize(double prize) {
			this.prize = prize;
		}

		@Override
		public void eat() {
			System.out.println("I am eating a waffle");

		}
	}
}
