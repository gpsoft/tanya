package jp.dip.gpsoft.tanya.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jp.dip.gpsoft.tanya.model.DiaryEntry;

// 警備サービス
@Service
public class GuardService {

	// 警備日誌
	private List<DiaryEntry> diaryList;

	{
		diaryList = new ArrayList<DiaryEntry>();
		diaryList.addAll(Arrays.asList(
				new DiaryEntry("異常ないニャ", "2018/02/01 09:00"),
				new DiaryEntry("お腹すいたニャ", "2018/02/01 13:00"),
				new DiaryEntry("異常ないニャ", "2018/02/02 09:00"),
				new DiaryEntry("お腹すいたニャ", "2018/02/02 13:00"),
				new DiaryEntry("異常ないニャ", "2018/02/03 09:00"),
				new DiaryEntry("お腹すいたニャ", "2018/02/03 13:00"),
				new DiaryEntry("いい天気ニャ", "2018/02/03 15:00")));
	}

	public List<DiaryEntry> latestDiary() {
		return diaryList.stream()
				.sorted(Comparator.comparing(DiaryEntry::getTimestamp).reversed())
				.limit(5)
				.collect(Collectors.toList());
	}

	public void addDiary(String comment) {
		diaryList.add(new DiaryEntry(comment,
				LocalDateTime.now()
						.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"))));
	}
}
