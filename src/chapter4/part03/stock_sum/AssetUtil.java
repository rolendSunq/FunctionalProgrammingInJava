package chapter4.part03.stock_sum;

import java.util.Arrays;
import java.util.List;

import chapter4.Asset;
import chapter4.Asset.AssetType;

public class AssetUtil {
	public static int totalAssetValues(final List<Asset> assets) {
		return assets.stream().mapToInt(asset -> asset.getType() == AssetType.STOCK ? asset.getValue() : 0).sum();
	}
	
	public static void main(String[] args) {
		final List<Asset> assets = Arrays.asList(
				new Asset(Asset.AssetType.BOND, 1000),
				new Asset(Asset.AssetType.BOND, 2000),
				new Asset(Asset.AssetType.STOCK, 3000),
				new Asset(Asset.AssetType.STOCK, 4000)
				);
		
		System.out.println("Total of all assets: " + totalAssetValues(assets));
	}
}
