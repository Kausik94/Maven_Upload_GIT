package com.los.restcontroller;

import com.los.entity.Feedback;
import com.los.entity.FoodOrder;
import com.los.service.FeedbackService;
import com.los.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;


@RestController
public class RestOrderController {


    @Autowired
    OrderService orderService;


    public static final Logger logger = LoggerFactory.getLogger(RestOrderController.class);
    @RequestMapping(
            value = "/api.order",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<FoodOrder>> getAllOrders(){
        List<FoodOrder> allOrders = orderService.getAllOrders();
        return new ResponseEntity<List<FoodOrder>>(allOrders, HttpStatus.OK);
    }


    @RequestMapping(
            value = "/api.order/{orderid}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FoodOrder> getOrderByOrderId(@PathVariable("orderid") int id ){
        FoodOrder order = orderService.getOrderById(id);
//        List<FoodOrder> allOrders = orderService.getAllOrders();
        return new ResponseEntity<FoodOrder>(order, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api.updateOrder/{orderid}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FoodOrder> updateOrderByOrderId(@PathVariable("orderid") int id ,@RequestBody FoodOrder foodOrder){
        FoodOrder currentOrder = orderService.getOrderById(id);

        if (currentOrder == null) {
            logger.error("Unable to update. User with id {} not found.", id);
            return new ResponseEntity(
                    HttpStatus.NOT_FOUND);
        }

        currentOrder.setProviderId(foodOrder.getProviderId());
        currentOrder.setMeal(foodOrder.getMeal());
        currentOrder.setQuantity(foodOrder.getQuantity());


        orderService.updateOrder(currentOrder);
        return new ResponseEntity<FoodOrder>(currentOrder, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api.deleteOrder/{orderid}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity<FoodOrder> deleteOrderByOrderId(@PathVariable("orderid") int id ){
        orderService.deleteOrder(id);
//        List<FoodOrder> allOrders = orderService.getAllOrders();
        return new ResponseEntity<FoodOrder>( HttpStatus.NO_CONTENT);
    }






    @RequestMapping(
            value = "/api.addOrder",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FoodOrder> addNewOrder(@RequestBody FoodOrder foodOrder) throws SQLException{
        System.out.println("add feedback is called");
        orderService.addOrder(foodOrder);
        return new ResponseEntity<FoodOrder>(foodOrder,HttpStatus.OK);
    }




}
