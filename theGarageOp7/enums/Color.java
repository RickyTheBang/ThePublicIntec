package theGarageOp7.enums;

import java.util.Random;

public enum Color {
	BLACK(0, 0, 0), WHITE(255, 255, 255), RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255), YELLOW(255, 255, 0);

	int[] rgb = new int[3];

	Color(int r, int g, int b) {
		this.rgb[0] = r;
		this.rgb[1] = g;
		this.rgb[2] = b;

	}

	public int[] getRgb() {
		return rgb;
	}

	public static Color generateRandomColor() {

		Color[] values = Color.values();
		Color color = null;
		Random ran = new Random();
		int pos = ran.nextInt(Color.values().length);
		color = values[pos];
		return color;
	}

}
