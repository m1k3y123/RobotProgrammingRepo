package part1.search.problem.structure;

import java.util.Arrays;


public class AStarAgenda extends BreadthFirstAgenda
{
    public void sort()
    {
	Arrays.sort(m_list.toArray());
    }
    
}
