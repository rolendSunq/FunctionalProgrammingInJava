package chapter4.part02.new_version;

import java.util.Arrays;
import java.util.List;

import chapter4.Asset;

public class AssetUtil {
	public static int totalAssetValues(final List<Asset> assets) {
		return assets.stream().mapToInt(Asset::getValue).sum();
	}
	
	public static void main(String[] args) {
		final List<Asset> assets = Arrays.asList(
				new Asset(Asset.AssetType.BOND, 1000),
				new Asset(Asset.AssetType.STOCK, 2000),
				new Asset(Asset.AssetType.STOCK, 3000),
				new Asset(Asset.AssetType.STOCK, 4000)
				);
		
		System.out.println("Total of all assets: " + totalAssetValues(assets));
	}
}
