import java.util.Arrays;

import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import scala.Tuple2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("hadoop.home.dir", "C:\\Users\\Alicja\\winutils\\");
		
		// create Spark context with Spark configuration
		JavaSparkContext sc = new JavaSparkContext(new SparkConf().setAppName("Spark Count").setMaster("local"));

		JavaRDD<String> textFile = sc.textFile("C:\\Users\\Alicja\\Desktop\\example.txt");
		JavaPairRDD<String, Integer> counts = textFile
				.flatMap(s -> Arrays.asList(s.split(" ")).iterator())
				.mapToPair(word -> new Tuple2<>(word, 1))
				.reduceByKey((a, b) -> a + b);
		counts.saveAsTextFile("C:\\Users\\Alicja\\Desktop\\example2.txt");
		counts.foreach(data -> {
			System.out.println("word= " + data._1() + " " + " occurance= " + data._2());
		});
	}
}
