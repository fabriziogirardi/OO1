package ar.edu.unlp.info.oo1.ejercicio1.impl;

import ar.edu.unlp.info.oo1.ejercicio1.WallPost;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 */
public class WallPostImpl implements WallPost
{

    private String text = "Undefined post";
    private int likes;
    private boolean featured;

    @Override
    public String toString()
    {
        return "WallPost {" +
               "text: " + getText() +
               ", likes: '" + getLikes() + "'" +
               ", featured: '" + isFeatured() + "'" +
               "}";
    }

    @Override
    public String getText()
    {
        return text;
    }

    @Override
    public void setText(String text)
    {
        this.text = text;
    }

    @Override
    public int getLikes()
    {
        return likes;
    }

    @Override
    public void like()
    {
        likes++;
    }

    @Override
    public void dislike()
    {
        if (likes > 0)
        {
            likes--;
        }
    }

    @Override
    public boolean isFeatured()
    {
        return featured;
    }

    @Override
    public void toggleFeatured()
    {
        featured = !featured;
    }
}
