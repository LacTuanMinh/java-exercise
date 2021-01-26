package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TelevisionShowCollectionImpl implements TelevisionShowCollection {

    private final List<TelevisionShow> tvShows = new ArrayList<>();

    @Override
    public TelevisionShowIterator iterator() {
        return new TelevisionShowIteratorImpl(tvShows);
    }

    @Override
    public void addShow(TelevisionShow show) {
        tvShows.add(show);
    }

    @Override
    public TelevisionShowIterator channelIterator(Channel channel) {
        return new TelevisionShowIteratorImpl(tvShows, channel);
    }

    private class TelevisionShowIteratorImpl implements TelevisionShowIterator {

        private List<TelevisionShow> tvShows;
        private int position = -1;

        public TelevisionShowIteratorImpl(List<TelevisionShow> tvShows) {
            this.tvShows = tvShows;
        }

        public TelevisionShowIteratorImpl(List<TelevisionShow> tvShows, Channel channel) {
            List<TelevisionShow> temp = new ArrayList<>();

            for (TelevisionShow show : tvShows) {
                if (channel.equals(show.getChannel())) {
                    temp.add(show);
                }
            }
            this.tvShows = temp;
        }

        @Override
        public boolean hasNext() {
            return position + 1 < tvShows.size();
        }

        @Override
        public TelevisionShow next() {
            if (hasNext()) {
                return tvShows.get((++position));
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return position - 1 >= -1;
        }

        @Override
        public TelevisionShow previous() {
            if (hasPrevious()) {
                return tvShows.get(position--);
            }
            throw new NoSuchElementException();
        }
    }
}
