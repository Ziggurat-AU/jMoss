package Util;

import Model.SessionModel;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataReader {
	private String _filename;

	public DataReader() {

	}

	public DataReader(String filename) {
		_filename = filename;
	}

	public ArrayList<SessionModel> read(String cinema) throws Exception {
		File file = new File("cinema.csv");
		Scanner input = new Scanner(file);

		ArrayList<SessionModel> dataTotal = new ArrayList<SessionModel>();

		while (input.hasNext()) {
			String line = input.nextLine();
			StringTokenizer st = new StringTokenizer(line, ",");
			String venue = st.nextToken();
			if(!venue.equals(cinema))
				continue;
			String movie = st.nextToken();
			String date = st.nextToken();
			String time = st.nextToken();

			/*
			 * DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); Date SessionDate; try {
			 * SessionDate = df.parse(Date); String newDateString = df.format(Date);
			 * System.out.println(newDateString); } catch (ParseException e) {
			 * e.printStackTrace(); }
			 */

			// boolean found = false;

			SessionModel dataInput_new = new SessionModel(venue, movie, date, time);
			dataTotal.add(dataInput_new);

		}

		input.close();
		return dataTotal;
	}
}
