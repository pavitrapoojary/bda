import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class Word_Driver
{
    public static void main(String[] args) throws Exception
    {
        Configuration conf= new Configuration();
        @SuppressWarnings(value="deprecation")
        Job job = new Job(conf,"My Word Count Program");
        job.setJarByClass(Word_Driver.class);
        job.setMapperClass(Word_Mapper.class);
        job.setReducerClass(Word_Reducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ?0 : 1);
    }
}
