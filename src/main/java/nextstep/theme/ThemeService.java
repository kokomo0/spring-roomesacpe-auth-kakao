package nextstep.theme;

import nextstep.exception.BusinessException;
import nextstep.exception.ErrorCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService {
    private ThemeDao themeDao;

    public ThemeService(ThemeDao themeDao) {
        this.themeDao = themeDao;
    }

    public Long create(ThemeRequest themeRequest) {
        return themeDao.save(themeRequest.toEntity());
    }

    public List<Theme> findAll() {
        return themeDao.findAll();
    }

    public void delete(Long id) {
        Theme theme = themeDao.findById(id);
        if (theme == null) {
            throw new BusinessException(ErrorCode.NOT_EXIST_THEME);
        }

        themeDao.delete(id);
    }
}
