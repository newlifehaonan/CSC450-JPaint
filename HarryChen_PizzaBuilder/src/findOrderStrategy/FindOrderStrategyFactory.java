package findOrderStrategy;

import orders.Order;

public class FindOrderStrategyFactory{


    public static IFindOrderStrategy getFindByRewardsNumberStrategy() {

        return  new IFindOrderStrategy() {
            @Override
            public String getFindByAttribute(Order order) {
                return order.getRewardsMemberNumber();
            }
        };

    }

    public static IFindOrderStrategy getFindByLastNameStrategy() {

        return new IFindOrderStrategy() {
            @Override
            public String getFindByAttribute(Order order) {
                return order.getLastName();
            }
        };
    }

    public static IFindOrderStrategy getFindByOrderNumberStrategy() {

        return new IFindOrderStrategy() {
            @Override
            public String getFindByAttribute(Order order) {
                return order.getOrderNumber();
            }
        };
    }


}
