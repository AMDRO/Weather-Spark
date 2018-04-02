package com.weather.app.controller;

import org.apache.spark.api.java.*;
import org.apache.spark.api.java.function.Function;

import com.weather.app.model.DataModel;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SparkSession sc = SparkSession.builder().appName("Spark count").master("local")
				.config("spark.some.config.option", "some-value").getOrCreate();

		// create RDD - load weather data from file and create RDD<String>
		JavaRDD<DataModel> weatherRDD = sc.read().textFile("/Users/user/Documents/GitHub/Weather-Spark/weatherData/*")
				.javaRDD().map(new Function<String, DataModel>() {

					public DataModel call(String row) throws Exception {
						DataModel dataModel = new DataModel();
						int rowLength = Integer.valueOf(row.substring(0, 4)) + 105;
						dataModel.setRecord_sign_amount(rowLength);

						String idWeatherStation = row.substring(4, 10);
						dataModel.setWeather_station_id(idWeatherStation);

						String idWeatherNcei = row.substring(10, 15);
						dataModel.setNcei_weather_station_id(idWeatherNcei);

						// date as String
						String date = row.substring(15, 27);

						// date as Date java class
						DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
						LocalDateTime dateFormatted = LocalDateTime.parse(date, format);
						dataModel.setObservation_date(dateFormatted.toString());

						String flag = row.substring(27, 28);
						dataModel.setData_source_flag(flag);

						String latitude = row.substring(28, 34);
						dataModel.setLatitude_coordinate(latitude);

						String longitude = row.substring(34, 41);
						dataModel.setLongitude_coordinate(longitude);

						String surfaceObsType = row.substring(41, 46);
						dataModel.setGeophysical_surface_obs_type(surfaceObsType);

						String elevationHeight = row.substring(46, 51);
						dataModel.setGeophysical_obs_point_elevation_height(elevationHeight);

						String callLetterId = row.substring(51, 56);
						dataModel.setWeather_station_call_letter_id(callLetterId);

						String qualityProcess = row.substring(56, 60);
						dataModel.setQuality_control_process(qualityProcess);

						String windObsDirectionAngle = row.substring(60, 63);
						dataModel.setWind_obs_direction_angle(windObsDirectionAngle);

						String windObsDirectionQualityCode = row.substring(63, 64);
						dataModel.setWind_obs_direction_quality_code(windObsDirectionQualityCode);

						String windObsTypeCode = row.substring(64, 65);
						dataModel.setWind_obs_type_code(windObsTypeCode);

						String windObsSpeedRate = row.substring(65, 69);
						dataModel.setWind_obs_speed_rate(windObsSpeedRate);

						String windObsSpeedQualityCode = row.substring(69, 70);
						dataModel.setWind_obs_speed_quality_code(windObsSpeedQualityCode);

						String skyObsCeilingHeight = row.substring(70, 75);
						dataModel.setSky_cond_obs_ceiling_height(skyObsCeilingHeight);

						String skyObsCeilingQualityCode = row.substring(75, 76);
						dataModel.setSky_cond_obs_ceiling_quality_code(skyObsCeilingQualityCode);

						String skyObsCeilingDeterminationCode = row.substring(76, 77);
						dataModel.setSky_cond_obs_ceiling_determination_code(skyObsCeilingDeterminationCode);

						String skyObsCavokCode = row.substring(77, 78);
						dataModel.setSky_cond_obs_cavok_code(skyObsCavokCode);

						String visibilityObsDistanceDim = row.substring(78, 84);
						dataModel.setVisibility_obs_distance_dim(visibilityObsDistanceDim);

						String visibilityObsDistanceQualityCode = row.substring(84, 85);
						dataModel.setVisibility_obs_distance_quality_code(visibilityObsDistanceQualityCode);

						String visibilityObsVariabilityCode = row.substring(85, 86);
						dataModel.setVisibility_obs_variability_code(visibilityObsVariabilityCode);

						String visibilityObsQualityVariaCode = row.substring(86, 87);
						dataModel.setVisibility_obs_varia_quality_code(visibilityObsQualityVariaCode);

						String airTemp = row.substring(87, 92);
						dataModel.setAir_temp(airTemp);

						String airTempObsQualityCode = row.substring(92, 93);
						dataModel.setAir_temp_obs_quality_code(airTempObsQualityCode);

						String airTempObsDewPointTemp = row.substring(93, 98);
						dataModel.setAir_temp_obs_dew_point_temp(airTempObsDewPointTemp);

						String airTempObsDewPointQualityCode = row.substring(98, 99);
						dataModel.setAir_temp_obs_dew_point_quality_code(airTempObsDewPointQualityCode);

						String atmosObsSeaLevelPressure = row.substring(99, 104);
						dataModel.setAtmo_pres_obs_sea_level_pres(atmosObsSeaLevelPressure);

						String atmosObsSeaLevelPresQualityCode = row.substring(104, 105);
						dataModel.setAtmo_pres_obs_sea_level_pres_obs_quality_code(atmosObsSeaLevelPresQualityCode);

						return dataModel;
					}
				});
		System.out.println("There is : " + weatherRDD.count() + " rows");
		Dataset<Row> weatherDF = sc.createDataFrame(weatherRDD, DataModel.class);
		System.out.println("After changing to DataFrame: " + weatherDF.count());
		weatherDF.describe().show();
	}
}
