package Util;

import Bean.DataInput;

import java.util.ArrayList;

public class dataoutput {

	public static void main(String[] args) throws Exception {
		DataReader reader = new DataReader("cinema.csv");
		ArrayList<DataInput> allData = reader.read();

		for (DataInput inputs : allData) {
			System.out.println(inputs.getMovie() + "   " + inputs.getVenue() + "   " + inputs.getSessionDate() + "  "
					+ "  " + inputs.getTime());
		}
	}

}
