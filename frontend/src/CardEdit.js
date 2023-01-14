import React, { Component } from 'react';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
class CardEdit extends Component {

    constructor(props) {
        super(props);

        this.state = {
          cardDetails: {
            name: props.name,
            cardNumber: props.cardNo,
            limit: props.limit
          }
        }
        this.handleChange = this.handleChange.bind(this);
                  this.handleSubmit = this.handleSubmit.bind(this);
      }

      async handleSubmit(event) {
          event.preventDefault();
          const {cardDetails} = this.state;

          const response = await fetch('/v1/cards', {
              method: 'POST',
              headers: {
                  'Accept': 'application/json',
                  'Content-Type': 'application/json'
              },
              body: JSON.stringify(cardDetails),
          });
          if(response.status===201){
            window.location.reload();
          }else{

          }

      }
      handleChange(event) {
          const target = event.target;
          const value = target.value;
          const name = target.name;
          let cardDetails = {...this.state.cardDetails};
          cardDetails[name] = value;
          this.setState({cardDetails});
      }
    render() {
    const item = this.state.cardDetails;

    return (
    <div>
    <Container float-left>
                      <h2>Credit Card System</h2>

                      <Form onSubmit={this.handleSubmit}>
                          <FormGroup>
                              <Label for="name">Name</Label>
                              <Input type="text" name="name" id="name" value={item.name || ''}
                                     onChange={this.handleChange} autoComplete="name"/>
                          </FormGroup>
                          <FormGroup>
                              <Label for="cardNumber">Card Number</Label>
                              <Input type="text" name="cardNumber" id="cardNumber" value={item.cardNumber || ''}
                                     onChange={this.handleChange} autoComplete="card Number"/>
                          </FormGroup>
                          <FormGroup>
                              <Label for="limit">Limit</Label>
                              <Input type="text" name="limit" id="limit" value={item.limit || ''}
                                     onChange={this.handleChange} autoComplete="limit"/>
                          </FormGroup>
                          <FormGroup>
                              <Button color="primary" type="submit" color="secondary">Add</Button>{' '}
                          </FormGroup>
                      </Form>
                  </Container>
                  </div>
                  );
                  }
}
export default CardEdit;