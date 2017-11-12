package com.weather.app.model;
import java.io.Serializable;

public class DataModel implements Serializable {

	private int record_sign_amount;
	private String weather_station_id;
	private String ncei_weather_station_id;
	private String observation_date;
	private String data_source_flag;
	private String latitude_coordinate;
	private String longitude_coordinate;
	private String geophysical_surface_obs_type; // obs = observation
	private String geophysical_obs_point_elevation_height;

	private String weather_station_call_letter_id;
	private String quality_control_process;
	private String wind_obs_direction_angle;
	private String wind_obs_direction_quality_code;
	private String wind_obs_direction_type_code;
	private String wind_obs_speed_rate;
	private String wind_obs_speed_quality_code;
	private String sky_cond_obs_ceiling_height; // cond = condition
	private String sky_cond_obs_ceiling_quality_code;
	private String sky_cond_obs_ceiling_determination_code;

	private String sky_cond_obs_cavok_code;
	private String visibility_obs_distance_dim; // dim = dimension
	private String visibility_obs_distance_quality_code;
	private String visibility_obs_variability_code;
	private String visibility_obs_varia_quality_code; // varia = variability
	private String air_temp; // temp = temperature
	private String air_temp_obs_quality_code;
	private String air_temp_obs_dew_point_temp;
	private String air_temp_obs_dew_point_quality_code;
	private String atmo_pres_obs_sea_level_pres; // atmo = atmospheric, pres = pressure

	private String atmo_pres_obs_sea_level_pres_obs_quality_code;
	private String additional_data;

	
	public int getRecord_sign_amount() {
		return record_sign_amount;
	}

	public void setRecord_sign_amount(int record_sign_amount) {
		this.record_sign_amount = record_sign_amount;
	}

	public String getWeather_station_id() {
		return weather_station_id;
	}

	public void setWeather_station_id(String weather_station_id) {
		this.weather_station_id = weather_station_id;
	}

	public String getNcei_weather_station_id() {
		return ncei_weather_station_id;
	}

	public void setNcei_weather_station_id(String ncei_weather_station_id) {
		this.ncei_weather_station_id = ncei_weather_station_id;
	}

	public String getObservation_date() {
		return observation_date;
	}

	public void setObservation_date(String observation_date) {
		this.observation_date = observation_date;
	}

	public String getData_source_flag() {
		return data_source_flag;
	}

	public void setData_source_flag(String data_source_flag) {
		this.data_source_flag = data_source_flag;
	}

	public String getLatitude_coordinate() {
		return latitude_coordinate;
	}

	public void setLatitude_coordinate(String latitude_coordinate) {
		this.latitude_coordinate = latitude_coordinate;
	}

	public String getLongitude_coordinate() {
		return longitude_coordinate;
	}

	public void setLongitude_coordinate(String longitude_coordinate) {
		this.longitude_coordinate = longitude_coordinate;
	}

	public String getGeophysical_surface_obs_type() {
		return geophysical_surface_obs_type;
	}

	public void setGeophysical_surface_obs_type(String geophysical_surface_obs_type) {
		this.geophysical_surface_obs_type = geophysical_surface_obs_type;
	}

	public String getGeophysical_obs_point_elevation_height() {
		return geophysical_obs_point_elevation_height;
	}

	public void setGeophysical_obs_point_elevation_height(String geophysical_obs_point_elevation_height) {
		this.geophysical_obs_point_elevation_height = geophysical_obs_point_elevation_height;
	}

	public String getWeather_station_call_letter_id() {
		return weather_station_call_letter_id;
	}

	public void setWeather_station_call_letter_id(String weather_station_call_letter_id) {
		this.weather_station_call_letter_id = weather_station_call_letter_id;
	}

	public String getQuality_control_process() {
		return quality_control_process;
	}

	public void setQuality_control_process(String quality_control_process) {
		this.quality_control_process = quality_control_process;
	}

	public String getWind_obs_direction_angle() {
		return wind_obs_direction_angle;
	}

	public void setWind_obs_direction_angle(String wind_obs_direction_angle) {
		this.wind_obs_direction_angle = wind_obs_direction_angle;
	}

	public String getWind_obs_direction_quality_code() {
		return wind_obs_direction_quality_code;
	}

	public void setWind_obs_direction_quality_code(String wind_obs_direction_quality_code) {
		this.wind_obs_direction_quality_code = wind_obs_direction_quality_code;
	}

	public String getWind_obs_direction_type_code() {
		return wind_obs_direction_type_code;
	}

	public void setWind_obs_direction_type_code(String wind_obs_direction_type_code) {
		this.wind_obs_direction_type_code = wind_obs_direction_type_code;
	}

	public String getWind_obs_speed_rate() {
		return wind_obs_speed_rate;
	}

	public void setWind_obs_speed_rate(String wind_obs_speed_rate) {
		this.wind_obs_speed_rate = wind_obs_speed_rate;
	}

	public String getWind_obs_speed_quality_code() {
		return wind_obs_speed_quality_code;
	}

	public void setWind_obs_speed_quality_code(String wind_obs_speed_quality_code) {
		this.wind_obs_speed_quality_code = wind_obs_speed_quality_code;
	}

	public String getSky_cond_obs_ceiling_height() {
		return sky_cond_obs_ceiling_height;
	}

	public void setSky_cond_obs_ceiling_height(String sky_cond_obs_ceiling_height) {
		this.sky_cond_obs_ceiling_height = sky_cond_obs_ceiling_height;
	}

	public String getSky_cond_obs_ceiling_quality_code() {
		return sky_cond_obs_ceiling_quality_code;
	}

	public void setSky_cond_obs_ceiling_quality_code(String sky_cond_obs_ceiling_quality_code) {
		this.sky_cond_obs_ceiling_quality_code = sky_cond_obs_ceiling_quality_code;
	}

	public String getSky_cond_obs_ceiling_determination_code() {
		return sky_cond_obs_ceiling_determination_code;
	}

	public void setSky_cond_obs_ceiling_determination_code(String sky_cond_obs_ceiling_determination_code) {
		this.sky_cond_obs_ceiling_determination_code = sky_cond_obs_ceiling_determination_code;
	}

	public String getSky_cond_obs_cavok_code() {
		return sky_cond_obs_cavok_code;
	}

	public void setSky_cond_obs_cavok_code(String sky_cond_obs_cavok_code) {
		this.sky_cond_obs_cavok_code = sky_cond_obs_cavok_code;
	}

	public String getVisibility_obs_distance_dim() {
		return visibility_obs_distance_dim;
	}

	public void setVisibility_obs_distance_dim(String visibility_obs_distance_dim) {
		this.visibility_obs_distance_dim = visibility_obs_distance_dim;
	}

	public String getVisibility_obs_distance_quality_code() {
		return visibility_obs_distance_quality_code;
	}

	public void setVisibility_obs_distance_quality_code(String visibility_obs_distance_quality_code) {
		this.visibility_obs_distance_quality_code = visibility_obs_distance_quality_code;
	}

	public String getVisibility_obs_variability_code() {
		return visibility_obs_variability_code;
	}

	public void setVisibility_obs_variability_code(String visibility_obs_variability_code) {
		this.visibility_obs_variability_code = visibility_obs_variability_code;
	}

	public String getVisibility_obs_varia_quality_code() {
		return visibility_obs_varia_quality_code;
	}

	public void setVisibility_obs_varia_quality_code(String visibility_obs_varia_quality_code) {
		this.visibility_obs_varia_quality_code = visibility_obs_varia_quality_code;
	}

	public String getAir_temp() {
		return air_temp;
	}

	public void setAir_temp(String air_temp) {
		this.air_temp = air_temp;
	}

	public String getAir_temp_obs_quality_code() {
		return air_temp_obs_quality_code;
	}

	public void setAir_temp_obs_quality_code(String air_temp_obs_quality_code) {
		this.air_temp_obs_quality_code = air_temp_obs_quality_code;
	}

	public String getAir_temp_obs_dew_point_temp() {
		return air_temp_obs_dew_point_temp;
	}

	public void setAir_temp_obs_dew_point_temp(String air_temp_obs_dew_point_temp) {
		this.air_temp_obs_dew_point_temp = air_temp_obs_dew_point_temp;
	}

	public String getAir_temp_obs_dew_point_quality_code() {
		return air_temp_obs_dew_point_quality_code;
	}

	public void setAir_temp_obs_dew_point_quality_code(String air_temp_obs_dew_point_quality_code) {
		this.air_temp_obs_dew_point_quality_code = air_temp_obs_dew_point_quality_code;
	}

	public String getAtmo_pres_obs_sea_level_pres() {
		return atmo_pres_obs_sea_level_pres;
	}

	public void setAtmo_pres_obs_sea_level_pres(String atmo_pres_obs_sea_level_pres) {
		this.atmo_pres_obs_sea_level_pres = atmo_pres_obs_sea_level_pres;
	}

	public String getAtmo_pres_obs_sea_level_pres_obs_quality_code() {
		return atmo_pres_obs_sea_level_pres_obs_quality_code;
	}

	public void setAtmo_pres_obs_sea_level_pres_obs_quality_code(String atmo_pres_obs_sea_level_pres_obs_quality_code) {
		this.atmo_pres_obs_sea_level_pres_obs_quality_code = atmo_pres_obs_sea_level_pres_obs_quality_code;
	}

	public String getAdditional_data() {
		return additional_data;
	}

	public void setAdditional_data(String additional_data) {
		this.additional_data = additional_data;
	}

}
