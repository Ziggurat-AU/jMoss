import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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
		long sum = 0;

		
		ArrayList<DataInput> dataTotal = new ArrayList<DataInput>();

		while (input.hasNext()) {
			String line = input.nextLine();
			StringTokenizer st = new StringTokenizer(line, ",");
			int num = st.countTokens();
			String subs[] = new String[num];
			int j;

			for (j = 0; j < num; j++) {
				subs[j] = st.nextToken();
			}

			if (subs[9].equals("Hourly_Counts"))
				continue;

			// Check data_G2 if data already exists
			String Venue = subs[1];
			String Movie = subs[2];
			//Date SessionDate = Date.(subs[3]);
			//Long Count = Long.parseLong(subs[4]);

			boolean found = false;

			for (DataInput dataRecord : dataTotal) {
				if (dataRecord.getVenue().equals(Venue) && dataRecord.getMovie().equals(Movie)
						&& dataRecord.getSessionDate().equals(SessionDate)) {
					///dataRecord.updateCounts(Count);
					found = true;
					break;
				}
			}
			if (!found) {
				DataInput dataInput_new = new DataInput(Venue, Movie, SessionDate, SessionTime);
				dataTotal.add(dataInput_new);
			}
			
		}

			input.close();
		return dataTotal;
	}

}
