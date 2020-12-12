package com.matan.rest.webservices.restfulwebservices.helloworld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Tip {

	private List<String> tips = new ArrayList<String>();
	int amountOfTips = 0;
	Random random = new Random();

	public Tip() {
		tips.add(
				"Take time to know yourself. \"Know thyself\" said Aristotle. When you know who you are, you can be wise about your goals, your dreams, your standards, your convictions. Knowing who you are allows you to live your life with purpose and meaning.");
		tips.add(
				"A narrow focus brings big results. The number one reason people give up so fast is because they tend to look at how far they still have to go instead of how far they have come. But it's a series of small wins that can give us the most significant success");
		tips.add(
				"Show up fully. Don't dwell on the past, and don't daydream about the future, but concentrate on showing up fully in the present moment");
	}

	public void addTip(String tip) {
		tips.add(tip);
	}

	public String getOneTip(int id) {
		return tips.get(id);
	}

	public String getRandomTip() {
		amountOfTips = tips.size();
		int randomNumber = random.nextInt(amountOfTips);
		String tip = getOneTip(randomNumber);
		return tip;
	}
}
