package chapter4.part05.refectoring;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import chapter4.Asset;
import chapter4.Asset.AssetType;

public class AssetUtilRefectored {
	public static int totalAssetValues(final List<Asset> assets, final Predicate<Asset> assetSelector) {
		return assets.stream().filter(assetSelector).mapToInt(Asset::getValue).sum();
	}
	
	public static void main(String[] args) {
		final List<Asset> assets = Arrays.asList(
				new Asset(Asset.AssetType.BOND, 1000),
				new Asset(Asset.AssetType.BOND, 2000),
				new Asset(Asset.AssetType.STOCK, 3000),
				new Asset(Asset.AssetType.STOCK, 4000)
				);
		
		System.out.println("Total of bonds: " + totalAssetValues(assets, asset -> asset.getType() == AssetType.BOND));
		System.out.println("Total of stock: " + totalAssetValues(assets, asset -> asset.getType() == AssetType.STOCK));
	}
}
