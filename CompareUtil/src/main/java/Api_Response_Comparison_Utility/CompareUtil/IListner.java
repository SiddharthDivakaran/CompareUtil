package Api_Response_Comparison_Utility.CompareUtil;

import java.util.List;

public interface IListner {
	public void execute(List<List<String>> list);
	public void shutdown();
}
