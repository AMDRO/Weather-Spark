import org.apache.spark.api.java.*;
import org.apache.spark.api.java.function.Function;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.spark.SparkConf;

import com.weather.app.model.DataModel;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("hadoop.home.dir", "C:\\Users\\Alicja\\winutils\\");

		// create Spark context with Spark configuration
		JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("Spark Count").setMaster("local"));

		// create RDD - load weather data from file and create RDD<String>
		JavaRDD<String> weatherDataRDD = sc.textFile("C:\\Users\\Alicja\\Desktop\\007070-99999-2015");

		// count rows in RDD
		long count = weatherDataRDD.count();
		System.out.println("There is: " + count + " rows");

		// create model from String. change RDD<String> to RDD<DataModel>
		// Function<String, DataModel> first argument is original format, second is
		// result format
		JavaRDD<DataModel> modelDataRDD = weatherDataRDD.map(new Function<String, DataModel>() {

			// implementing methods from Function
			// processing each row, for each row method below is called and result is added
			// to result RDD
			@Override
			public DataModel call(String row) throws Exception {
				// create result Data Model
				DataModel dataModel = new DataModel();

				// row length = first 4 letters + 105
				int rowLength = Integer.valueOf(row.substring(0, 4)) + 105;
				dataModel.setRecord_sign_amount(rowLength);
				System.out.println("Row length: " + rowLength);

				// weather station id is next 7 characters
				String idWeatherStation = row.substring(4, 10);
				dataModel.setWeather_station_id(idWeatherStation);
				System.out.println("Weather station id: " + dataModel.getWeather_station_id());

				String idWeatherNcei = row.substring(10, 15);
				dataModel.setNcei_weather_station_id(idWeatherNcei);
				System.out.println("Weather ncei id: " + dataModel.getNcei_weather_station_id());

				// date as String
				String date = row.substring(15, 27);
				System.out.println("Date: " + date);

				// date as Date java class
				DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
				LocalDateTime dateFormatted = LocalDateTime.parse(date, format);
				System.out.println("Date formatted: " + dateFormatted);

				return dataModel;
			}
		});

		// new RDD also has 198 ROWS
		System.out.println("After changing to data model: " + modelDataRDD.count());
	}
}

/*
 * public static void main(String[] args) { // TODO Auto-generated method stub
 * 
 * System.setProperty("hadoop.home.dir", "C:\\Users\\Alicja\\winutils\\");
 * 
 * // create Spark context with Spark configuration JavaSparkContext sc = new
 * JavaSparkContext(new
 * SparkConf().setAppName("Spark Count").setMaster("local"));
 * 
 * 
 * //basic example JavaRDD<String> textFile =
 * sc.textFile("C:\\Users\\Alicja\\Desktop\\example.txt"); JavaPairRDD<String,
 * Integer> counts = textFile.flatMap(s ->
 * Arrays.asList(s.split(" ")).iterator()) .mapToPair(word -> new Tuple2<>(word,
 * 1)).reduceByKey((a, b) -> a + b);
 * counts.saveAsTextFile("C:\\Users\\Alicja\\Desktop\\example2.txt");
 * counts.foreach(data -> { System.out.println("word= " + data._1() + " " +
 * " occurance= " + data._2()); });
 * 
 * 
 * // create RDD JavaRDD<String> weatherData =
 * sc.textFile("C:\\Users\\Alicja\\Desktop\\readLine.txt");
 * 
 * String schemaString = "id color thing";
 * 
 * // generate the schema based on the string of schema List<StructField> fields
 * = new ArrayList<>(); for (String fieldName : schemaString.split(" ")) {
 * StructField field = DataTypes.createStructField(fieldName,
 * DataTypes.StringType, true); fields.add(field); }
 * 
 * StructType schema = DataTypes.createStructType(fields);
 * 
 * JavaRDD<Row> rowRDD = weatherData.map(new Function<String, Row>() {
 * 
 * @Override public Row call(String record) throws Exception { String[]
 * attributes = record.split(","); return RowFactory.create(attributes[0],
 * attributes[1].trim()); } });
 * 
 * }
 */
