import java.util.List;
import java.util.Set;

public class BagOfWords implements IBagOfWords{

	@Override
	public String type() {
		return "bag";
	}

	@Override
	public boolean createDataStructure(List<IWord> words) {
		return true;
	}

	@Override
	public Set<String> getBag(int bagSize) {
		return null;
	}

}
