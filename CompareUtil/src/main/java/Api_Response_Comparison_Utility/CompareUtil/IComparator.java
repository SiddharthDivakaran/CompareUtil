package Api_Response_Comparison_Utility.CompareUtil;

public interface IComparator<T> {
	public boolean compare(T data1,T data2);
	public void getData(String filePath1,String filePath2);
}
