import React from 'react';
import { Content, Card, CardItem, Text, Body } from 'native-base';

const TabTwo = () => {
  return (
    <Content padder style={{ marginTop: 0 }}>
      <Card style={{ flex: 0 }}>
        <CardItem>
          <Body>
            <Text>
              NativeBase builds a layer on top of React Native that provides you
              with basic set of components for mobile application development.
              This helps you to build world-class application experiences on
              native platforms.
            </Text>
          </Body>
        </CardItem>
      </Card>
    </Content>
  );
};

export default TabTwo;
