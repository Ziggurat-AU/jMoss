package Util;

import Bean.DataInput;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataReader {
	String _filename;

	public DataReader() {

	}

	public DataReader(String filename) {
		_filename = filename;
	}

	public ArrayList<DataInput> read() throws Exception {
		File file = new File(_filename);
		Scanner input = new Scanner(file);

		ArrayList<DataInput> dataTotal = new ArrayList<DataInput>();

		while (input.hasNext()) {
			String line = input.nextLine();
			StringTokenizer st = new StringTokenizer(line, ",");

			String Venue = st.nextToken();
			String Movie = st.nextToken();
			String Date = st.nextToken();
			String Time = st.nextToken();

			/*
			 * DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); Date SessionDate; try {
			 * SessionDate = df.parse(Date); String newDateString = df.format(Date);
			 * System.out.println(newDateString); } catch (ParseException e) {
			 * e.printStackTrace(); }
			 */

			// boolean found = false;

			DataInput dataInput_new = new DataInput(Venue, Movie, Date, Time);
			dataTotal.add(dataInput_new);

		}

		input.close();
		return dataTotal;
	}
}
