package java8.inaction.stream.chapter6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingByUsingTestMain {
	public static void main(String[] args) {
		List<BlogPost> posts = Arrays.asList(new BlogPost("실전 람다", "심성규", BlogPostType.GUIDE, 8)
				,new BlogPost("JAVA8 In Action", "라울", BlogPostType.REVIEW, 4)
				,new BlogPost("Christmas Jazz", "BGMC", BlogPostType.REVIEW, 7)
				,new BlogPost("New Iqos", "Micheal Nodam", BlogPostType.NEWS, 8)
				,new BlogPost("Interia", "Dennis Choi", BlogPostType.GUIDE, 6)
				,new BlogPost("Dasbueida Enjoy", "Ajun Kim", BlogPostType.GUIDE, 5)
				,new BlogPost("Brexit: EU diplomats briefed on Brexit trade deal", "Katya Adler", BlogPostType.NEWS, 4)
				,new BlogPost("Pope urges coronavirus vaccine access for all", "BBC", BlogPostType.NEWS, 7)
				,new BlogPost("The berry that keeps Asia looking young", "Claire Turrell", BlogPostType.NEWS, 7)
				,new BlogPost("Practice YouTube", "GCL", BlogPostType.GUIDE, 6)
				,new BlogPost("The Mandalorian", "Uppercut", BlogPostType.GUIDE, 8)
				,new BlogPost("Electric Lady Land", "Jimi Handrix", BlogPostType.GUIDE, 9)
				);
		
		Map<BlogPostType, List<BlogPost>> postPerType = posts.stream().collect(Collectors.groupingBy(BlogPost::getType));
		System.out.println("postPerType--->>>" + postPerType);
		
		Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = posts.stream().collect(Collectors.groupingBy(post -> new Tuple(post.getType(), post.getAuthor())));
		System.out.println("postsPerTypeAndAuthor--->>>" + postsPerTypeAndAuthor);
		
		Map<BlogPostType, Set<BlogPost>> postsPerTypeSet = posts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.toSet()));
		System.out.println("postsPerTypeSet--->>>" + postsPerTypeSet);
		
		// group by에 대한 결과로 groupingBy를 수행할 수 있다. 목록에서 저자로 분류하고, 그 다음으로 유형으로 그룹핑한다.
		Map<String, Map<BlogPostType, List<BlogPost>>> map = posts.stream().collect(Collectors.groupingBy(BlogPost::getAuthor, Collectors.groupingBy(BlogPost::getType)));
		System.out.println("map--->>>" + map);
		
		// 그룹화 된 결과에서 합계 얻기
		// 각 유형에 대한 좋아요 수를 계산한 총계 계산
		Map<BlogPostType, Double> averageLikesPerType = posts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.averagingInt(BlogPost::getLikes)));
		System.out.println("averageLikesPerType--->>>" + averageLikesPerType);
		
		Map<BlogPostType, Integer> likesPerType = posts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.summingInt(BlogPost::getLikes)));
		System.out.println("likesPerType--->>>" + likesPerType);
		
		// 그룹화 된 결과에서 최대 또는 최소값 얻기 - 가장 많은 좋아요를 가진 블로그 게시물을 가져오기
		Map<BlogPostType, Optional<BlogPost>> maxLikesPerPostType = posts.stream().collect(
				Collectors.groupingBy(BlogPost::getType, Collectors.maxBy(Comparator.comparingInt(BlogPost::getLikes))));
		System.out.println("maxLikesPerPostType--->>>" + maxLikesPerPostType);
		
		// 그룹화 된 결과에서 속성에 대한 요약 가져오기 - 수, 합계, 최소, 최대 및 평균을 나타내려 할때 Colloctors.summarizingInt()
		// 메소드를 사용한다.
		Map<BlogPostType, IntSummaryStatistics> likeStatisticsPerType = posts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.summarizingInt(BlogPost::getLikes)));
		System.out.println("likeStatisticsPerType--->>>" + likeStatisticsPerType);
		
		// 그룹화된 결과를 다른 유형으로 매핑 - 분류 결과를 mapping down stream 수집기로 더 복잡한 집계를 할 수 있다.
		// 각 블로그 게시물 유형에 대한 게시물의 제목으로 분류하기
		Map<BlogPostType, String> postsPerType = posts.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.mapping(BlogPost::getTitle, Collectors.joining(", ", "Post titles: [", "]"))));
		System.out.println("postsPerType--->>>" + postsPerType);
	}
	
}
