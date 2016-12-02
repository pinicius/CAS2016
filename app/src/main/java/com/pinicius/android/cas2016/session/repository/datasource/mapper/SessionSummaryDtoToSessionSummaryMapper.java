package com.pinicius.android.cas2016.session.repository.datasource.mapper;

import com.pinicius.android.cas2016.link.mapper.LinkDtoToLinkMapper;
import com.pinicius.android.cas2016.session.domain.model.SessionSummary;
import com.pinicius.android.casapiclient.model.SessionSummaryDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by pinicius on 29/11/16.
 */

public class SessionSummaryDtoToSessionSummaryMapper {
    private final LinkDtoToLinkMapper linkMapper = new LinkDtoToLinkMapper();

    public SessionSummary map(SessionSummaryDto sessionSummaryDto) {
        SessionSummary sessionSummary = new SessionSummary(sessionSummaryDto.getId(),
                sessionSummaryDto.getTitle(), linkMapper.map(sessionSummaryDto.getLinks()));
        return sessionSummary;
    }

    public List<SessionSummary> map(Collection<SessionSummaryDto> sessionSummaryDtos) {
        List<SessionSummary> sessionSummaries = new ArrayList<>();
        for (SessionSummaryDto sessionSummaryDto : sessionSummaryDtos) {
            sessionSummaries.add(map(sessionSummaryDto));
        }
        return sessionSummaries;
    }
}
