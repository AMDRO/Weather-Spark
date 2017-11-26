package com.weather.app.controller;

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
		JavaRDD<String> weatherDataRDD = sc.textFile("C:\\Users\\Alicja\\Desktop\\weatherData\\*\\*");

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
				dataModel.setObservation_date(dateFormatted.toString());
				System.out.println("Date formatted: " + dataModel.getObservation_date());

				String flag = row.substring(27, 28);
				dataModel.setData_source_flag(flag);
				System.out.println("Data source flag: " + dataModel.getData_source_flag());

				String latitude = row.substring(28, 34);
				dataModel.setLatitude_coordinate(latitude);
				System.out.println("Latitude coordinate: " + dataModel.getLatitude_coordinate());

				String longitude = row.substring(34, 41);
				dataModel.setLongitude_coordinate(longitude);
				System.out.println("Longitude coordinate: " + dataModel.getLongitude_coordinate());

				String surfaceObsType = row.substring(41, 46);
				dataModel.setGeophysical_surface_obs_type(surfaceObsType);
				System.out.println(
						"Geophysical surface observation type: " + dataModel.getGeophysical_surface_obs_type());

				String elevationHeight = row.substring(46, 51);
				dataModel.setGeophysical_obs_point_elevation_height(elevationHeight);
				System.out.println("Geophysical point observation elevation height: "
						+ dataModel.getGeophysical_obs_point_elevation_height());

				String callLetterId = row.substring(51, 56);
				dataModel.setWeather_station_call_letter_id(callLetterId);
				System.out.println("Weather station call letter id: " + dataModel.getWeather_station_call_letter_id());

				String qualityProcess = row.substring(56, 60);
				dataModel.setQuality_control_process(qualityProcess);
				System.out.println("Quality control process: " + dataModel.getQuality_control_process());

				String windObsDirectionAngle = row.substring(60, 63);
				dataModel.setWind_obs_direction_angle(windObsDirectionAngle);
				System.out.println("Wind obs direction angle: " + dataModel.getWind_obs_direction_angle());

				String windObsDirectionQualityCode = row.substring(63, 64);
				dataModel.setWind_obs_direction_quality_code(windObsDirectionQualityCode);
				System.out
						.println("Wind obs direction quality code: " + dataModel.getWind_obs_direction_quality_code());

				String windObsTypeCode = row.substring(64, 65);
				dataModel.setWind_obs_type_code(windObsTypeCode);
				System.out.println("Wind obs type code: " + dataModel.getWind_obs_type_code());

				String windObsSpeedRate = row.substring(65, 69);
				dataModel.setWind_obs_speed_rate(windObsSpeedRate);
				System.out.println("Wind obs speed rate: " + dataModel.getWind_obs_speed_rate());

				String windObsSpeedQualityCode = row.substring(69, 70);
				dataModel.setWind_obs_speed_quality_code(windObsSpeedQualityCode);
				System.out.println("Wind obs speed quality code: " + dataModel.getWind_obs_speed_quality_code());

				String skyObsCeilingHeight = row.substring(70, 75);
				dataModel.setSky_cond_obs_ceiling_height(skyObsCeilingHeight);
				System.out.println("Sky obs ceiling height: " + dataModel.getSky_cond_obs_ceiling_height());

				String skyObsCeilingQualityCode = row.substring(75, 76);
				dataModel.setSky_cond_obs_ceiling_quality_code(skyObsCeilingQualityCode);
				System.out.println("Sky obs ceiling quality code: " + dataModel.getSky_cond_obs_ceiling_quality_code());

				String skyObsCeilingDeterminationCode = row.substring(76, 77);
				dataModel.setSky_cond_obs_ceiling_determination_code(skyObsCeilingDeterminationCode);
				System.out.println("Sky obs ceiling determination code: "
						+ dataModel.getSky_cond_obs_ceiling_determination_code());

				String skyObsCavokCode = row.substring(77, 78);
				dataModel.setSky_cond_obs_cavok_code(skyObsCavokCode);
				System.out.println("Sky obs cavok  code: " + dataModel.getSky_cond_obs_cavok_code());

				String visibilityObsDistanceDim = row.substring(78, 84);
				dataModel.setVisibility_obs_distance_dim(visibilityObsDistanceDim);
				System.out.println("Visibility obs distance dimension: " + dataModel.getVisibility_obs_distance_dim());

				String visibilityObsDistanceQualityCode = row.substring(84, 85);
				dataModel.setVisibility_obs_distance_quality_code(visibilityObsDistanceQualityCode);
				System.out.println(
						"Visibility obs distance quality code: " + dataModel.getVisibility_obs_distance_quality_code());

				String visibilityObsVariabilityCode = row.substring(85, 86);
				dataModel.setVisibility_obs_variability_code(visibilityObsVariabilityCode);
				System.out
						.println("Visibility obs variability code: " + dataModel.getVisibility_obs_variability_code());

				String visibilityObsQualityVariaCode = row.substring(86, 87);
				dataModel.setVisibility_obs_varia_quality_code(visibilityObsQualityVariaCode);
				System.out.println(
						"Visibility obs quality varia code: " + dataModel.getVisibility_obs_varia_quality_code());

				String airTemp = row.substring(87, 92);
				dataModel.setAir_temp(airTemp);
				System.out.println("Air temperature: " + dataModel.getAir_temp());

				String airTempObsQualityCode = row.substring(92, 93);
				dataModel.setAir_temp_obs_quality_code(airTempObsQualityCode);
				System.out.println("Air temp obs quality code: " + dataModel.getAir_temp_obs_quality_code());

				String airTempObsDewPointTemp = row.substring(93, 98);
				dataModel.setAir_temp_obs_dew_point_temp(airTempObsDewPointTemp);
				System.out.println("Air temp obs dew point temp: " + dataModel.getAir_temp_obs_dew_point_temp());

				String airTempObsDewPointQualityCode = row.substring(98, 99);
				dataModel.setAir_temp_obs_dew_point_quality_code(airTempObsDewPointQualityCode);
				System.out.println(
						"Air temp obs dew point quality code: " + dataModel.getAir_temp_obs_dew_point_quality_code());

				String atmosObsSeaLevelPressure = row.substring(99, 104);
				dataModel.setAtmo_pres_obs_sea_level_pres(atmosObsSeaLevelPressure);
				System.out.println(
						"Atmosc pressure obs sea level pressure : " + dataModel.getAtmo_pres_obs_sea_level_pres());

				String atmosObsSeaLevelPresQualityCode = row.substring(104, 105);
				dataModel.setAtmo_pres_obs_sea_level_pres_obs_quality_code(atmosObsSeaLevelPresQualityCode);
				System.out.println("Atmos pres obs sea level pres quality code : "
						+ dataModel.getAtmo_pres_obs_sea_level_pres_obs_quality_code());

				return dataModel;
			}
		});

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
